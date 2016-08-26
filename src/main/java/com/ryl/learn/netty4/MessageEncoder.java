package com.ryl.learn.netty4;

import com.google.protobuf.MessageLite;
import com.ryl.learn.netty4.pojo.ChatHeartBeat;
import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by renyulong on 16/2/2.
 * 自定义protobuf encode 多种proto类型
 */
public class MessageEncoder extends MessageToByteEncoder<MessageLite> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageLite msg, ByteBuf out) throws Exception {
        byte[] body = msg.toByteArray();
        byte[] header = encodeHeader(msg, (short) body.length);
        out.writeBytes(header);
        out.writeBytes(body);
    }

    //header byte[4] = byte[2](length) + byte[1](0) + byte[1](type)
    private byte[] encodeHeader(MessageLite msg, short length) {
        byte type = 0x0f;
        //定义消息类型
        if (msg instanceof ChatMessage.ChatRequest) {
            type = 0x01;
        } else if (msg instanceof ChatMessage.ChatResponse) {
            type = 0x02;
        } else if (msg instanceof ChatHeartBeat.HeartBeatPing) {
            type = 0x03;
        } else if (msg instanceof ChatHeartBeat.HeartBeatPong) {
            type = 0x04;
        }
        byte[] header = new byte[4];
        header[0] = (byte) (length & 0xff);
        header[1] = (byte) ((length >> 8) & 0xff);
        header[2] = 0;
        header[3] = type;
        return header;
    }
}
