package com.itheima.service.impl.rabbitmq.direct.listener;

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

    @RabbitListener(queues = "direct_queue")
    public void receive(String id){
        System.out.println("已完成短信发送业务(rabbitmq direct)，id:"+id);
    }



}
