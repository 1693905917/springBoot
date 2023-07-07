package com.itheima;

import com.itheima.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationBaseConfiguration {

    public static void main(String[] args) {
        //ConfigurableApplicationContext这就是我们ApplicationContext的子类，也就是我们spring容器的接口
        ConfigurableApplicationContext run = SpringApplication.run(
                ApplicationBaseConfiguration.class, args);
        //SpringApplication.run()方法也就是SpringBoot工程运行后初始化Spring容器，扫描引导类所在包加载bean
        BookController bookController = run.getBean(BookController.class);
        System.out.println("bookController++++"+bookController);
        User user = run.getBean(User.class);
        System.out.println("user++++"+user);
    }

}
