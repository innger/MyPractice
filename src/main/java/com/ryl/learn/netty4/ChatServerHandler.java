package com.ryl.learn.netty4;

import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

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
        ChatMessage.ChatRequest request = (ChatMessage.ChatRequest) msg;
        Utils.LOG.info("ChatServerHandler channelRead id={} from={} touser={} content={} date={}",
                request.getId(), request.getFrom(), request.getTouser(), request.getContent(), request.getDate());
        ChatMessage.ChatResponse response = ChatMessage.ChatResponse.newBuilder()
                .setId(request.getId())
                .setCode(2)
                .setMsg("received")
                .build();
        ctx.channel().writeAndFlush(response);
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
