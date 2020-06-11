package com.xigua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xigua
 * @description EnableEurekaClient表示在启动后会自动注册进Eureka中
 * EnableDiscoveryClient 服务发现的标签
 * @date 2020/6/4
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableScheduling
public class Microservicecloud_7778_App {
    public static void main(String[] args) {
        SpringApplication.run(Microservicecloud_7778_App.class, args);
    }
}
