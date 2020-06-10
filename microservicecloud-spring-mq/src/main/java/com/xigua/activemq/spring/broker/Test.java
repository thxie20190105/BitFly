package com.xigua.activemq.spring.broker;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xigua
 * @description
 * @date 2020/6/9
 **/
public class Test {
    private static final String ACTIVE_URL = "tcp://localhost:61616";

    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("msg" + i);
            producer.send(textMessage);
        }
        //9、关闭资源、提交事务
        producer.close();
        session.close();
        connection.close();
        System.out.println("操作完成");


    }
}
