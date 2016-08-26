package com.ryl.learn.netty4;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created on 16/8/26 下午2:02.
 * 超时关闭channel
 */
public class IdleTimeoutHandler extends ChannelDuplexHandler {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState e = ((IdleStateEvent) evt).state();
            if (e == IdleState.ALL_IDLE) {
                //fire a channelInactive to trigger publish of Will
                Utils.LOG.warn("IdleTimeoutHandler timeout connectionLost user={}", Utils.user(ctx.channel()));
//                ctx.fireChannelInactive();
                ctx.close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
