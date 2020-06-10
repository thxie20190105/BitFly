package com.xigua.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xigua
 * @description
 * @date 2020/6/10
 **/
@SpringBootTest(classes = Microservicecloud_7777_App.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMq {

    @Autowired
    private MqProduce mqProduce;

    @Test
    public void testSend() throws Exception {
        mqProduce.produceMsg();
        mqProduce.produceMsgScheduled();
    }

}
