package com.itheima;

import com.itheima.bean.CartoonCatAndMouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.bean
 * @Author: ASUS
 * @CreateTime: 2023-07-24  15:10
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication(excludeName = "org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration")
//@Import(CartoonCatAndMouse.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);
        CartoonCatAndMouse bean = run.getBean(CartoonCatAndMouse.class);
        bean.play();
    }
}
