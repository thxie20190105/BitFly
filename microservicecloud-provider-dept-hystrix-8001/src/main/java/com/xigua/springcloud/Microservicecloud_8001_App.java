package com.xigua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xigua
 * @description
 * EnableEurekaClient表示在启动后会自动注册进Eureka中
 * EnableDiscoveryClient 服务发现的标签
 * EnableCircuitBreaker 启动断路器
 * @date 2020/6/4
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class Microservicecloud_8001_App {
    public static void main(String[] args) {
        SpringApplication.run(Microservicecloud_8001_App.class, args);
    }
}
