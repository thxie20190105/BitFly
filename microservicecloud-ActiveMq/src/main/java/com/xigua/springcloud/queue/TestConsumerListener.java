package com.xigua.springcloud.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author xigua
 * @description
 * @date 2020/6/9
 **/
public class TestConsumerListener {
    private static final String ACTIVE_MQ_URL = "tcp://192.168.17.17:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);

        Connection connection = activeMQConnectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(queue);

        //使用消息监听的模式
        consumer.setMessageListener(message -> {
            if (null != message && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消费者收到的信息" + textMessage.getText());
                    System.out.println("消息属性" + textMessage.getStringProperty("p1"));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            } else if (null != message && message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                try {
                    System.out.println(mapMessage.getString("k1"));
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });


        //保证控制台灭
        System.in.read();
        consumer.close();
        session.close();
        connection.close();


    }
}
