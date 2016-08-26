package com.ryl.learn.netty4;

import com.google.common.collect.Maps;
import com.google.protobuf.MessageLite;
import com.ryl.learn.netty4.pojo.ChatHeartBeat;
import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.Map;

/**
 * Created by renyulong on 16/2/2.
 * 自定义protobuf encode 多种proto类型
 */
public class MessageEncoder extends MessageToByteEncoder<MessageLite> {

    private final Map<Class, Byte> protobufMap = Maps.newHashMap();

    public MessageEncoder() {
        ////定义消息类型
        protobufMap.put(ChatMessage.ChatRequest.class, (byte) 0x01);
        protobufMap.put(ChatMessage.ChatResponse.class, (byte) 0x02);
        protobufMap.put(ChatHeartBeat.HeartBeatPing.class, (byte) 0x03);
        protobufMap.put(ChatHeartBeat.HeartBeatPong.class, (byte) 0x04);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageLite msg, ByteBuf out) throws Exception {
        byte[] body = msg.toByteArray();
        byte[] header = encodeHeader(msg, (short) body.length);
        out.writeBytes(header);
        out.writeBytes(body);
    }

    //header byte[4] = byte[2](length) + byte[1](0) + byte[1](type)
    private byte[] encodeHeader(MessageLite msg, short length) {
        Byte type = protobufMap.get(msg.getClass());
        if (type == null) {
            Utils.LOG.warn("MessageEncoder encodeHeader invalid type {}", msg.getClass());
            type = (byte) (0xff);
        }
        byte[] header = new byte[4];
        header[0] = (byte) (length & 0xff);
        header[1] = (byte) ((length >> 8) & 0xff);
        header[2] = 0;
        header[3] = type;
        return header;
    }
}
