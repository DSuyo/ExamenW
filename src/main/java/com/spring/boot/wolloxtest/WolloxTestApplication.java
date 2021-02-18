package com.spring.boot.wolloxtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WolloxTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WolloxTestApplication.class, args);
    }

}
