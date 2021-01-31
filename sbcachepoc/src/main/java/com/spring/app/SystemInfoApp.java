package com.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SystemInfoApp {

    public static void main(String[] args) {
        SpringApplication.run(SystemInfoApp.class, args);
    }


}


