package com.xigua.springcloud.topic.presistent;

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
        System.out.println("***z3");

        //1、创建连接
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        //2、获得连接表明有一个张三订阅
        connection.setClientID("z3");
        //3、获得session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        //创建一个持久化的订阅者
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark");

        //挪下来的原因是要在启动之前设置好持久化属性，才能启动
        connection.start();
        Message message = topicSubscriber.receive();
        while (null != message) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println(textMessage.getText());
            message = topicSubscriber.receive(2000L);
        }

        session.close();
        connection.close();
    }
}
