package com.xigua.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xigua
 * @description 等同于springapplicationXML
 * @date 2020/6/4
 **/
@Configuration
@EnableEurekaClient
public class ConfigBean {

    /**
     * @return 返回REST模板
     * 配置ribbon负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

}
