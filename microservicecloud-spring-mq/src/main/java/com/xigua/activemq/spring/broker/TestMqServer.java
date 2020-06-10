package com.xigua.activemq.spring.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * @author xigua
 * @description 启动失败。
 * @date 2020/6/10
 **/
public class TestMqServer {

    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
