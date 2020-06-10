package com.xigua.activemq.spring.topic.presistent;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xigua
 * @description 持久化的Topic
 * @date 2020/6/10
 **/
public class TestTopicProcucer {
    private static final String ACTIVE_MQ_URL = "tcp://192.168.17.17:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer producer = session.createProducer(topic);
        //设置持久化
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        //挪下来的原因是要在启动之前设置好持久化属性，才能启动
        connection.start();
        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("TOPIC-MSG" + i);
            producer.send(textMessage);

        }

        producer.close();
        session.close();
        connection.close();

        System.out.println("订阅发布到MQ完成");


    }
}
