package com.xigua.activemq.spring.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xigua
 * @description
 * @date 2020/6/9
 **/
public class TestConsumer {
    private static final String ACTIVE_URL = "tcp://192.168.17.17:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        System.out.println("我是1号消费者");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);

        //5、创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //6、接受消息
        while (true) {
            TextMessage message = (TextMessage) consumer.receive(2000L);
            if (null != message) {
                System.out.println("消息为" + message.getText());
            } else {
                break;
            }
        }
        //消费成功
        session.commit();
        consumer.close();
        session.close();
        connection.close();

        System.out.println("消费完毕");

    }
}
