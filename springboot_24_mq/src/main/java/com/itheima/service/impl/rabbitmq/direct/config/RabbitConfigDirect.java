package com.itheima.service.impl.rabbitmq.direct.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
public class RabbitConfigDirect {

    @Bean
    //创建消息队列
    public Queue directQueue(){
        // durable:是否持久化,默认ture
        // exclusive:是否当前连接专用，默认false，连接关闭后队列即被删除
        // autoDelete:是否自动删除，当生产者或消费者不再使用此队列，自动删除,默认false
        return new Queue("direct_queue");
    }

    @Bean
    //创建消息队列
    public Queue directQueue2(){
        // durable:是否持久化,默认ture
        // exclusive:是否当前连接专用，默认false，连接关闭后队列即被删除
        // autoDelete:是否自动删除，当生产者或消费者不再使用此队列，自动删除,默认false
        return new Queue("direct_queue2");
    }

    @Bean
    //创建交换机
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    //创建交换机与消息队列的绑定
    public Binding bingingDirect(){
        //with方法是用来给这组绑定取给名字
        return BindingBuilder.bind(directQueue()).to(directExchange())
                .with("direct");
    }
    @Bean
    //创建交换机与消息队列的绑定
    public Binding bingingDirect2(){
        //with方法是用来给这组绑定取给名字
        return BindingBuilder.bind(directQueue2()).to(directExchange())
                .with("direct2");
    }


}
