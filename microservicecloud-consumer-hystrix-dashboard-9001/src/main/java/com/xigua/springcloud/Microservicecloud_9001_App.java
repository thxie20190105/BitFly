package com.xigua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author xigua
 * @description EnableHystrixDashboard开启仪表盘监控注解
 * @date 2020/6/4
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class Microservicecloud_9001_App {
    public static void main(String[] args) {
        SpringApplication.run(Microservicecloud_9001_App.class, args);
    }
}
