package com.xigua.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
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
    private Queue queue;

    @Autowired
    public MqProduce(JmsMessagingTemplate template, Queue queue) {
        this.template = template;
        this.queue = queue;
    }

    public void produceMsg() {
        //宝石发送到我的队列里面，第二个参数设置负载
        template.convertAndSend(queue,
                "*****：" + UUID.randomUUID().
                        toString().
                        substring(0, 6));
    }

    /**
     * 定时投放任务
     */
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled() {
        template.convertAndSend(queue,
                "*****Scheduled：" + UUID.randomUUID().
                        toString().
                        substring(0, 6));
    }
}
