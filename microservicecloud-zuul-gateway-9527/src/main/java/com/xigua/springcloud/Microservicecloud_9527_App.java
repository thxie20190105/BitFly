package com.xigua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author xigua
 * @description EnableZuulProxy起到一个代理的作用
 * @date 2020/6/8
 **/
@SpringBootApplication
@EnableZuulProxy
public class Microservicecloud_9527_App {
    public static void main(String[] args) {
        SpringApplication.run(Microservicecloud_9527_App.class, args);
    }
}
