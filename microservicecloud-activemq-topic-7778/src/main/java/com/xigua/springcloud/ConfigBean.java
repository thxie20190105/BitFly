package com.xigua.springcloud;


import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Topic;


/**
 * @author xigua
 * @description 读取队列接口
 * EnableJms 表示开始JMS的注解
 * @date 2020/6/10
 **/
@Component
@EnableJms
public class ConfigBean {

    @Value("${mytopic}")
    private String myTopic;

    /**
     * @return 返回一个队列
     */
    @Bean
    public Topic queue() {
        return new ActiveMQTopic(myTopic);
    }


}
