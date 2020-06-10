package com.xigua.activemq.spring.queue;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xigua
 * @description
 * @date 2020/6/9
 **/
public class TestProducer {
    //  private static final String ACTIVE_URL = "tcp://192.168.17.17:61616";
    private static final String ACTIVE_URL = "tcp://localhost:61616";

    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        //1、创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、获得连接并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3、创建session     参数1事务   参数2签收
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地 引用JMS包
        Queue queue = session.createQueue(QUEUE_NAME);
        //5、创建消息的生产者,并设置持久化属性
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //6、发送消息
        for (int i = 0; i <= 3; i++) {
            //7、创建消息体,设置消息头，设置消息属性
            TextMessage textMessage = session.createTextMessage("msg" + i);
            textMessage.setJMSMessageID("9999");
            textMessage.setStringProperty("p1", "vip");
            //8、通过消息生产者发送给mq，通过方法的重载可以设置优先级等属性。
            producer.send(textMessage);

            //Map消息体
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1", "v1");
            producer.send(mapMessage);

        }
        //9、关闭资源、提交事务
        session.commit();
        //session.rollback();
        producer.close();
        session.close();
        connection.close();
        System.out.println("操作完成");


    }
}
