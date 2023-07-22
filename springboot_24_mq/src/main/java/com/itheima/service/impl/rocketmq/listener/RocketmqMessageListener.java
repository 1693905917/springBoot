package com.itheima.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.rocketmq.listener
 * @Author: ASUS
 * @CreateTime: 2023-07-22  22:21
 * @Description: TODO
 * @Version: 1.0
 */
//将监听器交给spring管理
//@Component
//@RocketMQMessageListener注解是放在类上的，不是方法上
//需要添加两个参数：1.consumerGroup：你是哪一个消费组对应的信息 2.topic：你消费的信息来源于那个队列中
@RocketMQMessageListener(topic = "order_id",consumerGroup = "group_rocketmq")
//RocketMQListener<>:<>里面传递的是：你传递的消息是什么种类
public class RocketmqMessageListener implements RocketMQListener<String> {
    @Override
    //后面接收到的消息都会保存到onMessage方法的String message中
    public void onMessage(String message) {
        System.out.println("已经完成短信发送业务，RocketMQListener,id:"+message);
    }
}
