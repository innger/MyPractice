package com.ryl.learn.util;

import com.google.common.base.Charsets;
import org.joda.time.DateTime;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created on 16/9/1 下午2:23.
 */
public class NioSocketServer {

    public static final Integer PORT = 9527;

    private ServerSocketChannel ssc;
    private Selector selector;

    public NioSocketServer() throws IOException {
        selector = Selector.open();
        ssc = ServerSocketChannel.open();
        ssc.socket().setReuseAddress(true);
        ssc.configureBlocking(false);
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        ssc.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), PORT));

        System.out.println("NioSocketServer start");
    }

    public ByteBuffer encode(String str) {
        return Charsets.UTF_8.encode(str);
    }

    public String decode(ByteBuffer buffer) {
        return Charsets.UTF_8.decode(buffer).toString();
    }

    public void service() throws IOException {
        while (selector.select() > 0) {
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = null;
                try {
                    key = iter.next();
                    iter.remove();
                    if (key.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel sc = channel.accept();
                        System.out.println("accepted client remote address=" + sc.getRemoteAddress() + ",port=" + sc.socket().getLocalPort());
                        sc.configureBlocking(false);
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.register(selector, SelectionKey.OP_READ, buffer);
                    } else if (key.isReadable()) {
                        receive(key);
                    } else if (key.isWritable()) {

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (key != null) {
                        key.cancel();
                        key.channel().close();
                    }
                }
            }
        }
    }

    private void receive(SelectionKey key) throws IOException {
        if (key == null || !key.isReadable()) {
            return;
        }
        SocketChannel sc = (SocketChannel) key.channel();
        String receiveString;
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = sc.read(buffer);
        System.out.println("receive read=" + read + " buffer=" + buffer.capacity());
        if (read == -1) {
            sc.close();
        } else {
            buffer.flip();
            receiveString = Charsets.UTF_8.newDecoder().decode(buffer).toString();
            String[] contents = receiveString.split("\\n");
            for (String c : contents) {
                System.out.println("receive : " + c);
                String sendString = new DateTime().toString("yyyy-MM-dd HH:mm:ss.SSS")+" echo " + c+"\n";
                System.out.println(sendString);
                buffer = ByteBuffer.wrap(sendString.getBytes(Charsets.UTF_8));
                sc.write(buffer);
                key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new NioSocketServer().service();
    }

    public static void startServer() throws Exception {
        int channels = 0;
        int nKeys = 0;
        int currentSelector = 0;
        Selector selector = Selector.open();

        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9000);
        ssc.socket().bind(address);
        ssc.configureBlocking(false);

        SelectionKey s = ssc.register(selector, SelectionKey.OP_ACCEPT);
        printKeyInfo(s);
        System.out.println("Select server start.");
        while (true) {
            nKeys = selector.select();
            if (nKeys > 0) {
//                System.out.println("Number of keys after select operation:"+nKeys);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectedKeys.iterator();
                while (i.hasNext()) {
                    s = i.next();
//                    printKeyInfo(s);
//                    System.out.println("Nr keys in selector:" + selector.keys().size());
                    i.remove();
                    if (s.isAcceptable()) {
                        Socket socket = ((ServerSocketChannel) s.channel()).accept().socket();
                        SocketChannel sc = socket.getChannel();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println(++channels);
                    }
                    if (s.isReadable()) {
                        Socket socket = ((SocketChannel) s.channel()).socket();
                        SocketChannel sc = socket.getChannel();
                        sc.configureBlocking(false);
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.read(buffer);
                        System.out.println("read byte:" + buffer.toString());
                    }
                }
            } else {
//                System.out.println("Select finished without any keys.");
            }
        }

    }

    private static void printKeyInfo(SelectionKey key) {
        StringBuilder s = new StringBuilder("Att:").append(key.attachment() == null ? "no" : "yes");
        s.append(",Read:").append(key.isReadable());
        s.append(",Acpt:").append(key.isAcceptable());
        s.append(",Cnct:").append(key.isConnectable());
        s.append(",Wrt:").append(key.isWritable());
        s.append(",Valid:").append(key.isValid());
        s.append(",Ops:").append(key.interestOps());
        System.out.println(s.toString());
    }

}
