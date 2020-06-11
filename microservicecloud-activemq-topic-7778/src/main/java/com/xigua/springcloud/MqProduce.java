package com.xigua.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

/**
 * @author xigua
 * @description
 * @date 2020/6/10
 **/
@Component
public class MqProduce {

    /**
     * 模板
     */
    private JmsMessagingTemplate template;

    /**
     * 队列
     */
    private Topic topic;

    @Autowired
    public MqProduce(JmsMessagingTemplate template, Topic topic) {
        this.template = template;
        this.topic = topic;
    }

    /**
     * 定时投放任务
     */
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled() {
        template.convertAndSend(topic,
                "*****主题消息：" + UUID.randomUUID().
                        toString().
                        substring(0, 6));
    }
}
