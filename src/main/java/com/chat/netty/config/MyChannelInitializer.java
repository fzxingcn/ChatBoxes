package com.chat.netty.config;

import com.chat.netty.handling.MessageHandling;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class MyChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        // Http消息编码解码
        pipeline.addLast("http-codec", new HttpServerCodec());
        // Http消息组装
        pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
        // WebSocket通信支持
        pipeline.addLast("http-chunked", new ChunkedWriteHandler());
        //指定处理类
        pipeline.addLast("handler", new MessageHandling());

    }
}
