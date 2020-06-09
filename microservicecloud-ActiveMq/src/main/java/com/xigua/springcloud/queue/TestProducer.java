package com.xigua.springcloud.queue;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xigua
 * @description
 * @date 2020/6/9
 **/
public class TestProducer {
    private static final String ACTIVE_URL = "tcp://192.168.17.17:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        //1、创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、获得连接并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3、创建session     参数1事务   参数2签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地 引用JMS包
        Queue queue = session.createQueue(QUEUE_NAME);
        //5、创建消息的生产者
        MessageProducer producer = session.createProducer(queue);
        //6、发送消息
        for (int i = 0; i <= 3; i++) {
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("msg" + i);
            //8、通过消息生产者发送给mq
            producer.send(textMessage);

        }
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("操作完成");


    }
}
