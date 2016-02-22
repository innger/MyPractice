package com.ryl.learn.netty4.ticket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;
import java.util.Date;

/**
 * Created by renyulong on 16/2/19.
 */
public class TicketClientHandler extends ChannelOutboundHandlerAdapter {


    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        super.connect(ctx, remoteAddress, localAddress, promise);

        Ticket ticket = new Ticket(1000L,"ryl","beijing","anyang",new Date());
        System.out.println("TicketClientHandler connect send ticket="+ticket);
        ctx.writeAndFlush(ticket);

    }

}

