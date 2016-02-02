package com.ryl.learn.netty4;

import com.alibaba.fastjson.JSON;
import com.ryl.learn.mybatis.pojo.UserInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by renyulong on 16/1/28.
 */
public class ChatServerHandler extends ChannelInboundHandlerAdapter {

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channels.add(ctx.channel());
        System.out.println("ChatServerHandler channelActive add." + channels.size());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ChatServerHandler channelRead begin" + msg);
        UserInfoVo user = JSON.parseObject(msg.toString(), UserInfoVo.class);
        System.out.println(user);
        if (msg instanceof UserInfoVo) {
            System.out.println("userInfo received");
        }
        if (msg instanceof MessageVo) {
            System.out.println("message received");
        }
        ctx.channel().writeAndFlush(msg);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        channels.remove(ctx.channel());
        System.out.println("ChatServerHandler channelInactive " + channels.size());
        super.channelInactive(ctx);
    }
}
