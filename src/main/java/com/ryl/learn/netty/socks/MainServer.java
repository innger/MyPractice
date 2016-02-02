package com.ryl.learn.netty.socks;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by renyulong on 16/1/26.
 */
public class MainServer {

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService work = Executors.newCachedThreadPool();
        ServerBootstrap serverBootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(boss, work)
        );

        ClientSocketChannelFactory cf = new NioClientSocketChannelFactory(boss, work);

        serverBootstrap.setPipelineFactory(new SocksProxyPipelineFactory(cf));

        serverBootstrap.bind(new InetSocketAddress(1080));

    }
}
