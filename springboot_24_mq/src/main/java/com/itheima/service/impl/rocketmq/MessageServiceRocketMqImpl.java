package com.itheima.service.impl.rocketmq;

import com.itheima.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.rocketmq
 * @Author: ASUS
 * @CreateTime: 2023-07-22  22:14
 * @Description: TODO
 * @Version: 1.0
 */
//@Service
public class MessageServiceRocketMqImpl implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列（RocketMq）,id:"+id);
        //convertAndSend是同步请求
        //rocketMQTemplate.convertAndSend("order_id",id);

        //asyncSend是异步请求
        SendCallback callback=new SendCallback() {
            @Override
            //发送反馈成功
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }
            @Override
            //发送反馈失败
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败");
            }
        };
        rocketMQTemplate.asyncSend("order_id",id,callback);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
