package com.xigua.springcloud;

import com.xigua.ribbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class Microservicecloud_80_App {
    public static void main(String[] args) {
        SpringApplication.run(Microservicecloud_80_App.class, args);
    }
}
