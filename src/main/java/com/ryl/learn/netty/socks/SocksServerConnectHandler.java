package com.ryl.learn.netty.socks;

import com.sun.tools.internal.ws.wsdl.document.Output;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.handler.codec.socks.SocksCmdRequest;
import org.jboss.netty.handler.codec.socks.SocksCmdResponse;
import org.jboss.netty.handler.codec.socks.SocksMessage;

import java.net.InetSocketAddress;

/**
 * Created by renyulong on 16/1/26.
 */
public class SocksServerConnectHandler extends SimpleChannelUpstreamHandler {

    private static final String name = "SOCKS_SERVER_CONNECT_HANDLER";

    public static String getName(){
        return name;
    }

    private final ClientSocketChannelFactory cf;

    public SocksServerConnectHandler(ClientSocketChannelFactory cf){
        this.cf = cf;
    }

    private volatile Channel outboundChannel;

    final Object trafficlock = new Object();

    @Override
    public void messageReceived(final ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        final SocksCmdRequest socksCmdRequest = (SocksCmdRequest) e.getMessage();
        final Channel inboundChannel = e.getChannel();
        inboundChannel.setReadable(false);

        ClientBootstrap cb = new ClientBootstrap(cf);
        cb.setOption("keepAlive",true);
        cb.setOption("tcpNoDelay",true);
        cb.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("outboundChannel",new OutboundHandler(inboundChannel,"out"));
                return pipeline;
            }
        });

        ChannelFuture future = cb.connect(new InetSocketAddress(socksCmdRequest.getHost(),socksCmdRequest.getPort()));
        outboundChannel = future.getChannel();
        ctx.getPipeline().remove(getName());

        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if(channelFuture.isSuccess()){
                    inboundChannel.getPipeline().addLast("inboundChannel",new OutboundHandler(outboundChannel,"int"));
                    inboundChannel.write(new SocksCmdResponse(SocksMessage.CmdStatus.SUCCESS,socksCmdRequest.getAddressType()));
                }else{
                    inboundChannel.write(new SocksCmdResponse(SocksMessage.CmdStatus.FAILURE,socksCmdRequest.getAddressType()));
                    inboundChannel.close();
                }
            }
        });

        super.messageReceived(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        super.exceptionCaught(ctx, e);
    }

    private class OutboundHandler extends SimpleChannelUpstreamHandler {
        private final Channel inboundChannel;

        private String name;

        public OutboundHandler(Channel in,String name){
            this.inboundChannel = in;
            this.name = name;
        }

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            ChannelBuffer msg = (ChannelBuffer) e.getMessage();
            synchronized (trafficlock){
                inboundChannel.write(msg);
            }
        }

        @Override
        public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            closeOnFlush(inboundChannel);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
            e.getCause().printStackTrace();
            closeOnFlush(e.getChannel());
        }
    }


    static void closeOnFlush(Channel ch){
        if(ch.isConnected()){
            ch.write(ChannelBuffers.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }
}
