package com.itheima.service.impl.rabbitmq.topic;

import com.itheima.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.rabbitmq.direct
 * @Author: ASUS
 * @CreateTime: 2023-07-22  17:31
 * @Description: TODO
 * @Version: 1.0
 */
//@Service
public class MessageServiceRabbitMqTopicImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列,id:"+id);
        amqpTemplate.convertAndSend("topicExchange","topic.order.id",id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
