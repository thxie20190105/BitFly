package com.xigua.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * @author xigua
 * @description
 * @date 2020/6/10
 **/
@Service
public class MqPro {

    private JmsTemplate template;

    @Autowired
    public MqPro(JmsTemplate template) {
        this.template = template;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //默认首字母小写
        MqPro mqPro = (MqPro) applicationContext.getBean("mqPro");
        mqPro.template.send(session -> {
            TextMessage textMessage = session.createTextMessage("spring+mq整合练习");
            return textMessage;
        });
    }
}
