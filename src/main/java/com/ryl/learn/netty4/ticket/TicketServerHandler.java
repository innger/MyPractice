package com.ryl.learn.netty4.ticket;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by renyulong on 16/2/19.
 */
public class TicketServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        Ticket ticket = (Ticket) msg;
        System.out.println("TicketServerHandler channelRead ticket="+ticket);


    }
}
