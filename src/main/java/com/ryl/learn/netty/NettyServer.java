package com.ryl.learn.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Netty Server
 * Created by renyulong on 16/1/18.
 */
public class NettyServer {

    public static void main(String[] args) {
        Server server = new Server();
        server.config(8080);
        server.start();
    }


}

class Server {

    private ServerBootstrap bootstrap;
    private Channel parentChannel;
    private InetSocketAddress localAddress;
    private MyChannelHandler channelHandler = new MyChannelHandler();

    public Server() {
        bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()
        ));

        bootstrap.setOption("reuseAddress", true);
        bootstrap.setOption("child.tcpNoDelay", true);
        bootstrap.setOption("child.soLinger", 2);

        bootstrap.getPipeline().addLast("servercnfactory", channelHandler);
    }

    public void config(int port) {
        this.localAddress = new InetSocketAddress(port);
    }

    public void start() {
        parentChannel = bootstrap.bind(localAddress);
    }


    class MyChannelHandler extends SimpleChannelHandler {


        @Override
        public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("channel closed [" + e + "]");
        }

        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("channel connected [" + e + "]");
        }

        @Override
        public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("channel open [" + e + "]");
        }

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            System.out.println("new message " + e.getMessage().toString() + " from " + ctx.getChannel());
            processMessage(e);
        }

        private void processMessage(MessageEvent e) {
            ChannelBuffer buf = (ChannelBuffer) e.getMessage();
            String msg = "";
            byte[] bytes = new byte[1024];
            while (buf.readable()) {
                buf.readBytes(bytes);
                msg += new String(bytes);
            }
            System.out.println(msg);
//            Channel ch = e.getChannel();
//            ch.write(e.getMessage());
        }
    }
}
