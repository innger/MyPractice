package com.ryl.learn.netty4;

import com.google.protobuf.ByteString;
import com.ryl.learn.netty4.pojo.ChatHeartBeat;
import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by renyulong on 16/1/28.
 * ChatServerHandler 处理业务
 */
public class ChatServerHandler extends ChannelInboundHandlerAdapter {

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channels.add(ctx.channel());
        Utils.LOG.info("ChatServerHandler channelActive add {}", channels.size());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String user = Utils.user(ctx.channel());
        if (msg instanceof ChatMessage.ChatRequest) {
            ChatMessage.ChatRequest request = (ChatMessage.ChatRequest) msg;
            long id = request.getId();
            String from = request.getFrom();
            String touser = request.getTouser();
            String content = request.getContent();
            String date = request.getDate();
            if (StringUtils.isEmpty(user)) {
                Utils.LOG.info("ChatServerHandler channelRead init set channel user={}", from);
                Utils.user(ctx.channel(), request.getFrom());
            } else {
                if (!from.equals(user)) {
                    Utils.LOG.warn("ChatServerHandler channelRead user={} not match from={}", user, from);
                }
            }
            Utils.LOG.info("ChatServerHandler channelRead id={} from={} touser={} content={} date={}", id, from, touser, content, date);
            ChatMessage.ChatResponse response = ChatMessage.ChatResponse.newBuilder()
                    .setId(request.getId())
                    .setCode(2)
                    .setMsg("received")
                    .build();
            ctx.channel().writeAndFlush(response);
            Utils.LOG.info("ChatServerHandler channelWrit id={} code={} msg={}", request.getId(), 2, "received");
        } else if(msg instanceof ChatHeartBeat.HeartBeatPing) {
            ChatHeartBeat.HeartBeatPing ping = (ChatHeartBeat.HeartBeatPing) msg;
            Utils.LOG.info("ChatServerHandler channelRead heartbeat user={} {}", user, new String(ping.getPing().toByteArray()));
            ByteString b = ByteString.copyFrom("pong".getBytes());
            ChatHeartBeat.HeartBeatPong pong = ChatHeartBeat.HeartBeatPong.newBuilder().setPong(b).build();
            ctx.channel().writeAndFlush(pong);
        } else {
            Utils.LOG.warn("ChatServerHandler channelRead not match message type");
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        channels.remove(ctx.channel());
        Utils.LOG.info("ChatServerHandler channelInactive {}", channels.size());
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    }
}
