package com.chat;

import com.chat.netty.service.NettyServicerStart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ChatBoxesApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(ChatBoxesApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        new NettyServicerStart(9001);
        System.out.println("后端服务启动成功#########################");
    }
}
