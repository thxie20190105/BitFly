package com.xigua.activemq.spring.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author xigua
 * @description
 * @date 2020/6/10
 **/
public class TestTopicConsumer {
    private static final String ACTIVE_MQ_URL = "tcp://192.168.17.17:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("我是3号消费者");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(message -> {
            if (null != message && message instanceof TextMessage) {
                TextMessage t = (TextMessage) message;
                try {
                    System.out.println("TOPIC消息为+" + t.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
