package com.ryl.learn.netty4;

import com.alibaba.fastjson.JSON;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.commons.lang3.RandomUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by renyulong on 16/1/28.
 */
public class MainClient {

    public static void main(String[] args){
        int port = 8000;
        EventLoopGroup work = new NioEventLoopGroup(1);

        try{
            Bootstrap b = new Bootstrap();
            b.group(work)
             .channel(NioSocketChannel.class)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 protected void initChannel(SocketChannel ch) throws Exception {
                     ChannelPipeline p = ch.pipeline();

//                     p.addLast(new DelimiterBasedFrameDecoder(8*1024, Delimiters.lineDelimiter()));

                     p.addLast(new MessageEncoder());

                     p.addLast(new MessageDecoder());
                     p.addLast(new ChatClientHandler());

                 }
             });

            Channel ch = b.connect("127.0.0.1",8000).sync().channel();
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                String line = in.readLine();
                if(line == null){
                    break;
                }

                MessageVo vo = new MessageVo(new Random().nextInt(),"ryl",line);
                ch.writeAndFlush(vo);

                UserInfoVo user = new UserInfoVo(new Random().nextLong(),line+"@qq.com",new Random().nextDouble());
                ch.writeAndFlush(user);

//                lastWriteFuture = ch.writeAndFlush(Delimiters.lineDelimiter());

                if("bye".equalsIgnoreCase(line)){
                    ch.closeFuture().sync();
                    break;
                }
            }

            if(lastWriteFuture != null){
                lastWriteFuture.sync();
                System.exit(0);
            }



        }catch (Exception ex){

        }finally {
            work.shutdownGracefully();
        }
    }
}
