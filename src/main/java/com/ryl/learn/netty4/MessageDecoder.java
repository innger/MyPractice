package com.ryl.learn.netty4;

import com.google.protobuf.MessageLite;
import com.ryl.learn.netty4.pojo.ChatHeartBeat;
import com.ryl.learn.netty4.pojo.ChatMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by renyulong on 16/2/2.
 * 自定义protobuf decoder
 */
public class MessageDecoder extends ByteToMessageDecoder {

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
        if (type == 0x01) {
            return ChatMessage.ChatRequest.getDefaultInstance()
                    .getParserForType().parseFrom(array, offset, length);
        } else if (type == 0x02) {
            return ChatMessage.ChatResponse.getDefaultInstance()
                    .getParserForType().parseFrom(array, offset, length);
        } else if (type == 0x03) {
            return ChatHeartBeat.HeartBeatPing.getDefaultInstance()
                    .getParserForType().parseFrom(array, offset, length);
        } else if (type == 0x04) {
            return ChatHeartBeat.HeartBeatPong.getDefaultInstance()
                    .getParserForType().parseFrom(array, offset, length);
        }
        return null; // or throw exception
    }
}
