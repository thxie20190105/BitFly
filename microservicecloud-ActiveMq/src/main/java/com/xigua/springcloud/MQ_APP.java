package com.xigua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xigua
 * @description EnableHystrixDashboard开启仪表盘监控注解
 * @date 2020/6/4
 **/
@SpringBootApplication
public class MQ_APP {
    public static void main(String[] args) {
        SpringApplication.run(MQ_APP.class, args);
    }
}
