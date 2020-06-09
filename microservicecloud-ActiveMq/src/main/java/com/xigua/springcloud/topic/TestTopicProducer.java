package com.xigua.springcloud.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xigua
 * @description
 * @date 2020/6/10
 **/
public class TestTopicProducer {
    private static final String ACTIVE_MQ_URL = "tcp://192.168.17.17:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        MessageProducer producer = session.createProducer(topic);

        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("TOPIC-MSG" + i);
            producer.send(textMessage);

        }

        producer.close();
        session.close();
        connection.close();

        System.out.println("消息发布到MQ完成");


    }
}
