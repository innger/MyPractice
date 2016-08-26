package com.ryl.learn.netty4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;


/**
 * Created by renyulong on 16/1/28.
 * main server
 */
public class MainServer {

    public static void main(String[] args) {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addFirst("IdleHandler", new IdleStateHandler(0, 0, 10)); //netty自带idlehandler监听超时,并不关闭连接
                            p.addAfter("IdleHandler", "IdleTimeoutHandler", new IdleTimeoutHandler());  //传递给自定义handler处理
                            //decode
//                            p.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
                            p.addLast(new MessageDecoder());
                            //netty中每个管道仅能注册一个解码和编码的方式
//                            p.addLast(new ProtobufDecoder(ChatMessage.ChatRequest.getDefaultInstance()));
//                            p.addLast(new ProtobufDecoder(ChatHeartBeat.HeartBeatPing.getDefaultInstance())); //无效
                            //业务处理
                            p.addLast(new ChatServerHandler());
                            //encode
                            p.addLast(new MessageEncoder());
//                            p.addLast(new LengthFieldPrepender(4));
//                            p.addLast(new ProtobufEncoder());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.TCP_NODELAY, true);
            Utils.LOG.info("Chat MainServer startup {}:{}", Utils.localAddress(), Utils.PORT);
            bootstrap.bind(Utils.PORT).sync().channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }

}
