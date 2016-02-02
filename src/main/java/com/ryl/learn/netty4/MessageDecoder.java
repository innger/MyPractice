package com.ryl.learn.netty4;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by renyulong on 16/2/2.
 */
public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes() < 4){
            return;
        }
        in.markReaderIndex();
        int len = in.readInt();
        if(len < 0){
            ctx.close();
        }
        if(in.readableBytes() < len){
            in.resetReaderIndex();
            return;
        }
        byte[] body = new byte[len];
        in.readBytes(body);
        Object obj = JSON.parse(body);
        System.out.println("MessageDecoder obj="+obj);
        out.add(obj);
    }
}
