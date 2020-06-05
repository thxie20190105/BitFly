package com.xigua.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xigua
 * @description
 * @date 2020/6/5
 **/
@Configuration
public class MySelfRule {


    /**
     * @return 自定义算法覆盖默认的轮询算法
     */
    @Bean
    public IRule myRule() {
        return new RandomRule_XIGUA();
    }

}
