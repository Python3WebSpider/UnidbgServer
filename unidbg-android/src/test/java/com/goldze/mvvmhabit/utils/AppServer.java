package com.goldze.mvvmhabit.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppServer {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppServer.class);
        app.run(args);
    }
}
