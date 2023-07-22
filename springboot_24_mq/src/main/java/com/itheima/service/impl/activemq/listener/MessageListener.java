package com.itheima.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.activemq.listener
 * @Author: ASUS
 * @CreateTime: 2023-07-22  11:56
 * @Description: TODO
 * @Version: 1.0
 */
//要交给spring管控才能监听
//@Component
public class MessageListener {

    @JmsListener(destination = "order.other.queue.id")
    @SendTo("order.sm.queue.id")
    public String receive(String id){
        System.out.println("已完成短信发送业务，id:"+id);
        return "new:"+id;
    }


}
