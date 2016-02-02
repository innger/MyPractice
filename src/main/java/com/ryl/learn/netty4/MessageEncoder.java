package com.ryl.learn.netty4;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by renyulong on 16/2/2.
 */
public class MessageEncoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        System.out.println("MessageEncoder " + msg);
        byte[] body = JSON.toJSONBytes(msg);
        int len = body.length;
        out.writeInt(len);
        out.writeBytes(body);
    }
}
