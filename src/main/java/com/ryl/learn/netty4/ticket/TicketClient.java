package com.ryl.learn.netty4.ticket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by renyulong on 16/2/19.
 */
public class TicketClient {

    public static void main(String[] args) throws Exception {
        new TicketClient().connect("127.0.0.1",10001);
    }

    private void connect(String host, int port) throws Exception {

        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ObjectDecoder(1014*1024, ClassResolvers.weakCachingResolver(this.getClass().getClassLoader())));
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new TicketClientHandler());
                        }
                    });
            //发起异步服务器连接请求 同步等待成功
            ChannelFuture f = b.connect(host, port).sync();
            ////等到客户端链路关闭
            f.channel().closeFuture().sync();


        } finally {
            workGroup.shutdownGracefully();
        }


    }

}
