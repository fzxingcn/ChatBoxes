package com.chat.netty.service;

import com.chat.netty.config.MyChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty启动类
 * @author fzxing
 */
public class NettyServicerStart {


    public  NettyServicerStart(int port){
        startNettyServer(port);
    }

    public void  startNettyServer(int port) {
            System.out.println("启动Netty!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //当前线程池用于处理用户的链接
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            //当前线程池用于处理用户的IO操作或者定时器等等操作
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new MyChannelInitializer());
                Channel channel = bootstrap.bind(port).sync().channel();
                channel.closeFuture().sync();
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
    }
}
