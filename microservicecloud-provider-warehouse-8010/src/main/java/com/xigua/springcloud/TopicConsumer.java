package com.xigua.springcloud;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author xigua
 * @description
 * @date 2020/6/11
 **/
@Component
public class TopicConsumer {

    /**
     * 监听者topic主题
     *
     * @param message
     */
    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage message) {
        try {
            System.out.println("主题的消费者" + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
