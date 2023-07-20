package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.example
 * @Author: ASUS
 * @CreateTime: 2023-07-20  12:00
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class ScheduledBean {
    @Scheduled(cron = "0/5 * * * * ?")
    public void printLog(){
        System.out.println(Thread.currentThread().getName()+"spring task running....");
    }


}
