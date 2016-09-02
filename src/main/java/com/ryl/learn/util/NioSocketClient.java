package com.ryl.learn.util;

import com.google.common.base.Charsets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.UUID;

/**
 * Created on 16/9/1 下午3:35.
 */
public class NioSocketClient {

    private Selector selector;
    private SocketChannel socketChannel;

    public NioSocketClient() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(InetAddress.getLocalHost(), NioSocketServer.PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public void send(String message) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(Charsets.UTF_8));
        socketChannel.write(buffer);
    }

    public static void main(String[] args) throws Exception {
        NioSocketClient client = new NioSocketClient();
        new Reader(client.selector);
        for (int i = 0; i < 1024 * 104; i++) {
            String message = i + " [" + UUID.randomUUID().toString().replace("-", "") + "] 发送测试数据,接收吧\n";
            System.out.println(message);
            client.send(message);
            Thread.sleep(500);
        }
    }

    static class Reader implements Runnable {

        private Selector selector;

        public Reader(Selector selector) {
            this.selector = selector;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                while (selector.select() > 0) {
                    // 遍历每个有可用IO操作Channel对应的SelectionKey
                    for (SelectionKey sk : selector.selectedKeys()) {
                        // 如果该SelectionKey对应的Channel中有可读的数据
                        if (sk.isReadable()) {
                            // 使用NIO读取Channel中的数据
                            SocketChannel sc = (SocketChannel) sk.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            int read = sc.read(buffer);
                            if (read != -1) {
                                buffer.flip();
                                String receivedString = Charsets.UTF_8.newDecoder().decode(buffer).toString();
                                for (String str : receivedString.split("\\n")) {
                                    System.out.println("received from [" + sc.socket().getRemoteSocketAddress() + "] : " + str);
                                }
                            }
                            sk.interestOps(SelectionKey.OP_READ);
                        }
                        // 删除正在处理的SelectionKey
                        selector.selectedKeys().remove(sk);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
