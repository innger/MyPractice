package com.ryl.learn.netty4;

import com.ryl.learn.netty4.pojo.ChatHeartBeat;
import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.joda.time.DateTime;

/**
 * Created by renyulong on 16/1/28.
 * ChatClientHandler 处理业务
 */
public class ChatClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //初始化发送消息给server
        ChatMessage.ChatRequest request = ChatMessage.ChatRequest.newBuilder()
                .setId(System.currentTimeMillis())
                .setFrom(Utils.user(ctx.channel()))
                .setTouser("server")
                .setContent("connect")
                .setDate(new DateTime().toString("yyyy-MM-dd HH:mm:ss")).build();
        Utils.LOG.info("ChatClientHandler channelActive send message id={} from={} touser={} content={} date={}",
                request.getId(), request.getFrom(), request.getTouser(), request.getContent(), request.getDate());
        ctx.channel().writeAndFlush(request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof ChatMessage.ChatResponse) {
            ChatMessage.ChatResponse response = (ChatMessage.ChatResponse) msg;
            Utils.LOG.info("ChatClientHandler channelRead ChatResponse id={} code={} msg={}",
                    response.getId(), response.getCode(), response.getMsg());
        }
        if(msg instanceof ChatHeartBeat.HeartBeatPong) {
            ChatHeartBeat.HeartBeatPong pong = (ChatHeartBeat.HeartBeatPong) msg;
            Utils.LOG.info("ChatClientHandler channelRead ChatHeartBeat pong={}", new String(pong.getPong().toByteArray()));
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Utils.LOG.warn("ChatClientHandler channelInactive user={}", Utils.user(ctx.channel()));
        super.channelInactive(ctx);
        ctx.close();
        System.exit(1);
    }
}
