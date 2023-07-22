package com.itheima.service.impl.activemq;

import com.itheima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.activemq
 * @Author: ASUS
 * @CreateTime: 2023-07-22  11:27
 * @Description: TODO
 * @Version: 1.0
 */
//@Service
public class MessageServiceActiveMqImpl implements MessageService {

    @Autowired
    //ActiveMQ是基于JMS的，所以是设置ActiveMQ的实现接口
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列,id:"+id);
        //将你的数据先转换好ActiveMq能够接受的类型再发送出去,此时发送完，
        // 你的消息就会发送到对应的消息队列里面去。如果没有指定消息队列，
        // 系统会使用默认消息队列：itheima
        messagingTemplate.convertAndSend(
                "order.other.queue.id",id);
    }

    @Override
    public String doMessage() {
        //将消息接受并且转换成你需要的数据类型
        String id=messagingTemplate.receiveAndConvert(
                "order.other.queue.id"
                ,String.class);
        System.out.println("已完成短信发送业务，id:"+id);
        return id;
    }
}
