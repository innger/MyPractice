package com.ryl.learn.netty4;

import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * Created by renyulong on 16/1/28.
 * Main Client
 */
public class MainClient {

    public static void main(String[] args) {
        EventLoopGroup work = new NioEventLoopGroup(1);
        try {
            Bootstrap b = new Bootstrap();
            b.group(work).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            //decode
                            p.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
                            p.addLast(new ProtobufDecoder(ChatMessage.ChatResponse.getDefaultInstance()));

                            p.addLast(new ChatClientHandler());

                            //encode
                            p.addLast(new LengthFieldPrepender(4));
                            p.addLast(new ProtobufEncoder());


                        }
                    });
            b.connect(Utils.LOCAL, Utils.PORT).sync().channel().closeFuture().sync();
//            Channel ch = b.connect("127.0.0.1", Utils.PORT).sync().channel();
//            ChannelFuture lastWriteFuture = null;
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            for (; ;) {
//                String line = in.readLine();
//                if (line == null) {
//                    break;
//                }
//                MessageVo vo = new MessageVo(new Random().nextInt(), "ryl", line);
//                ch.writeAndFlush(vo);
//                UserInfoVo user = new UserInfoVo(new Random().nextLong(), line + "@qq.com", new Random().nextDouble());
//                ch.writeAndFlush(user);
////                lastWriteFuture = ch.writeAndFlush(Delimiters.lineDelimiter());
//                if ("bye".equalsIgnoreCase(line)) {
//                    ch.closeFuture().sync();
//                    break;
//                }
//            }
//
//            if (lastWriteFuture != null) {
//                lastWriteFuture.sync();
//                System.exit(0);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            work.shutdownGracefully();
        }
    }
}
