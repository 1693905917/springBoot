package com.itheima.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.rabbitmq.direct.listener
 * @Author: ASUS
 * @CreateTime: 2023-07-22  17:56
 * @Description: TODO
 * @Version: 1.0
 */
//@Component
public class MessageLister {

    @RabbitListener(queues = "topic_queue")
    public void receive(String id){
        System.out.println("已完成短信发送业务(rabbitmq direct)，id:"+id);
    }

    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id){
        System.out.println("已完成短信发送业务(rabbitmq direct2222)，id:"+id);
    }



}
