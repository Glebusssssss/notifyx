package com.notifyx.notifyx;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NotifyxApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotifyxApplication.class, args);
    }
}