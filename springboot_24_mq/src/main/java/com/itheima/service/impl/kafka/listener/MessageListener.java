package com.itheima.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.kafka.listener
 * @Author: ASUS
 * @CreateTime: 2023-07-22  23:21
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class MessageListener {

    @KafkaListener(topics = "itheima2022")
    //ConsumerRecord<String,String> record是封装好的消息数据
    public void onMessage(ConsumerRecord<String,String> record){
        System.out.println("已经完成短信发送业务，kafka,id:"+record.value());
    }

}
