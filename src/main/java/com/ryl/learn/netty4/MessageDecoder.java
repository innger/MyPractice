package com.ryl.learn.netty4;

import com.google.common.collect.Maps;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.ryl.learn.netty4.pojo.ChatHeartBeat;
import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.Map;

/**
 * Created by renyulong on 16/2/2.
 * 自定义protobuf decoder
 */
public class MessageDecoder extends ByteToMessageDecoder {

    private final Map<Byte, Parser> protobufMap = Maps.newHashMap();

    public MessageDecoder() {
        protobufMap.put((byte) 0x01, ChatMessage.ChatRequest.getDefaultInstance().getParserForType());
        protobufMap.put((byte) 0x02, ChatMessage.ChatResponse.getDefaultInstance().getParserForType());
        protobufMap.put((byte) 0x03, ChatHeartBeat.HeartBeatPing.getDefaultInstance().getParserForType());
        protobufMap.put((byte) 0x04, ChatHeartBeat.HeartBeatPong.getDefaultInstance().getParserForType());
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();

        byte low = in.readByte();
        byte high = in.readByte();
        short s0 = (short) (low & 0xff);
        short s1 = (short) (high & 0xff);
        s1 <<= 8;
        short length = (short) (s0 | s1);

        in.readByte(); //保留字节

        byte type = in.readByte();
        if (in.readableBytes() < length) {
            in.resetReaderIndex();
            return;
        }
        ByteBuf body = in.readBytes(length);
        byte[] array;
        int offset;
        int readable = body.readableBytes();
        if (body.hasArray()) {
            array = body.array();
            offset = body.arrayOffset() + body.readerIndex();
        } else {
            array = new byte[readable];
            body.getBytes(body.readerIndex(), array, 0, readable);
            offset = 0;
        }
        MessageLite result = decodeBody(type, array, offset, readable);
        out.add(result);
    }

    public MessageLite decodeBody(byte type, byte[] array, int offset, int length) throws Exception {
        Parser parser = protobufMap.get(type);
        if(parser != null) {
            return (MessageLite) parser.parseFrom(array, offset, length);
        }
        return null;
    }
}
