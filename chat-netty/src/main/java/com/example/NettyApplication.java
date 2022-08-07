package com.example;

import com.example.websocket.NioWebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author andilylzy
 * @date 2022/8/2 下午10:41
 */
@SpringBootApplication
public class NettyApplication implements CommandLineRunner {

    @Autowired
    private NioWebSocketServer server;


    public static void main(String[] args){
        SpringApplication.run(NettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.init();
    }
}
