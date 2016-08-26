package com.ryl.learn.netty4;

import com.google.protobuf.ByteString;
import com.ryl.learn.netty4.pojo.ChatHeartBeat;
import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by renyulong on 16/1/28.
 * Main Client
 */
public class MainClient {

    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        String user = RandomStringUtils.randomAlphabetic(10);
        EventLoopGroup work = new NioEventLoopGroup(1);
        try {
            Bootstrap b = new Bootstrap();
            b.group(work).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            //decode
                            p.addLast(new MessageDecoder());
//                            p.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
//                            p.addLast(new ProtobufDecoder(ChatMessage.ChatResponse.getDefaultInstance()));
//                            p.addLast(new ProtobufDecoder(ChatHeartBeat.HeartBeatPong.getDefaultInstance()));
                            //业务handler
                            p.addLast(new ChatClientHandler());
                            p.addLast(new MessageEncoder());
                            //encode
//                            p.addLast(new LengthFieldPrepender(4));
//                            p.addLast(new ProtobufEncoder());
                        }
                    });
//            b.connect(Utils.LOCAL, Utils.PORT).sync().channel().closeFuture().sync();
            final Channel ch = b.connect(Utils.localAddress(), Utils.PORT).sync().channel();
            Utils.user(ch, user);
            service.scheduleAtFixedRate(new HeartBeat(ch), 5, 5, TimeUnit.SECONDS);

            Utils.LOG.info("Chat client [{}] connected at {}:{}", user, Utils.localAddress(), Utils.PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                String line = in.readLine();
                if (line == null || "byte".equals(line)) {
                    ch.closeFuture().sync();
                    break;
                }
                long id = System.currentTimeMillis();
                String date = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
                ChatMessage.ChatRequest request = ChatMessage.ChatRequest.newBuilder()
                        .setId(id)
                        .setFrom(user)
                        .setContent(line)
                        .setTouser("server")
                        .setDate(date)
                        .build();
                Utils.LOG.info("Chat client send message id={} from={} touser=server content={} date={}", id, user, line, date);
                ch.writeAndFlush(request);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            work.shutdownGracefully();
        }
    }

    static class HeartBeat implements Runnable {

        private Channel channel;

        public HeartBeat(Channel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            ChatHeartBeat.HeartBeatPing ping = ChatHeartBeat.HeartBeatPing.newBuilder()
                    .setPing(ByteString.copyFrom("ping".getBytes()))
                    .build();
            channel.writeAndFlush(ping);
            Utils.LOG.info("Chat client heartbeat {} ping", Utils.user(channel));
        }
    }
}
