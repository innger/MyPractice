package com.ryl.learn.netty.socks;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.handler.codec.socks.SocksInitRequestDecoder;

/**
 * Created by renyulong on 16/1/26.
 */
public class SocksProxyPipelineFactory implements ChannelPipelineFactory {

    private final ClientSocketChannelFactory cf;

    public SocksProxyPipelineFactory(ClientSocketChannelFactory cf){
        this.cf = cf;
    }

    public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();

        pipeline.addLast(SocksInitRequestDecoder.class.getName(),new SocksInitRequestDecoder());
        pipeline.addLast(SocksMessageEncoder.getName(),new SocksMessageEncoder());
        pipeline.addLast(SocksServerHandler.getName(),new SocksServerHandler(cf));

        return pipeline;
    }
}
