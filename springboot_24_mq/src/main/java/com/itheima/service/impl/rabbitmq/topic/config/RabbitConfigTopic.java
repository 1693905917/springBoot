package com.itheima.service.impl.rabbitmq.topic.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl.rabbitmq.direct.config
 * @Author: ASUS
 * @CreateTime: 2023-07-22  17:37
 * @Description: TODO
 * @Version: 1.0
 */
//@Configuration
public class RabbitConfigTopic {

    @Bean
    //创建消息队列
    public Queue topicQueue(){
        return new Queue("topic_queue");
    }

    @Bean
    //创建消息队列
    public Queue topicQueue2(){
        return new Queue("topic_queue2");
    }

    @Bean
    //创建Topic交换机
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    //创建交换机与消息队列的绑定
    public Binding bingingDirect(){
        //with方法是用来给这组绑定取给名字
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }
    @Bean
    //创建交换机与消息队列的绑定
    public Binding bingingDirect2(){
        //with方法是用来给这组绑定取给名字
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.order.*");
    }


}
