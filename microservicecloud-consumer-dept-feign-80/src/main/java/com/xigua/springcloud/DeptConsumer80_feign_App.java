package com.xigua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
@SpringBootApplication
@EnableFeignClients("com.xigua.springcloud")
@EnableEurekaClient
public class DeptConsumer80_feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_feign_App.class, args);
    }
}


