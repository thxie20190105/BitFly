package com.xigua.springcloud.cof;

import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author xigua
 * @description
 * @date 2020/6/10
 **/
@Component
public class ConfigBean {

    @JmsListener(destination = "${myqueue}")
    public void recevie(TextMessage textMessage) throws JmsException, JMSException {
        System.out.println(textMessage.getText());
    }
}
