package com.xigua.activemq.spring.sch;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.util.UUID;

/**
 * @author xigua
 * @description
 * @date 2020/6/12
 **/
public class MqPro {
    //地址参数配置
    private static final String ACTIVE_URL = "tcp://192.168.17.17:61616?jms.useAsyncSend=true";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //工厂级别的
        //activeMQConnectionFactory.setUseAsyncSend(true);

        Connection connection = activeMQConnectionFactory.createConnection();
        //连接级别的
        //((ActiveMQConnection) connection).setUseAsyncSend(true);

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        //使用回调需要使用ActiveMQMessageProducer类，细粒度化
        ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(queue);

        //6、发送消息
        for (int i = 0; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("msg" + i);
            textMessage.setJMSMessageID("callback" + UUID.randomUUID().toString());
            String msgId = textMessage.getJMSMessageID();

            producer.send(textMessage, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("成功" + msgId);
                }

                @Override
                public void onException(JMSException exception) {
                    System.out.println("失败" + msgId);
                }
            });

        }
        producer.close();
        session.close();
        connection.close();
        System.out.println("操作完成");


    }
}
