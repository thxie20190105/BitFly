package com.xigua.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author xigua
 * @description
 * @date 2020/6/10
 **/
@Service
public class MqCon {
    private JmsTemplate template;

    @Autowired
    public MqCon(JmsTemplate template) {
        this.template = template;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MqCon mqCon = (MqCon) applicationContext.getBean("mqCon");
        String o = (String) mqCon.template.receiveAndConvert();
        System.out.println(o);
    }
}
