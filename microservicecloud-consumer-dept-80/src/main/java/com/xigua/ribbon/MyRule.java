package com.xigua.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xigua
 * @description
 * @date 2020/6/5
 **/
@Configuration
public class MyRule {


    /**
     * @return 自定义算法覆盖默认的轮询算法
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
