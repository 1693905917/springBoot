package com.example.config;

import com.example.QuartzTaskBean;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.example.config
 * @Author: ASUS
 * @CreateTime: 2023-07-20  11:39
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class QuartzConfig {
    @Bean
    //设置工作明细：用于描述定时工作相关的信息
    public JobDetail printJobDetail(){
        return JobBuilder
                .newJob(QuartzTaskBean.class)//绑定具体工作
                //storeDurably()：你这个工作创建出来以后，假定你没有去使用这个工作，是否要持久化一下，
                //先存储起来，如果你不写这个，系统会干掉这个具体工作
                .storeDurably()
                .build();
    }

    @Bean
    //设置触发器：用于描述触发工作的规则，通常使用cron表达式定义调度规则
    public Trigger printJobTrigger(){
        //"0/3 *  * *  *  ?"介绍：0/3指的是：从当前运行开始启动这个工作，并且以3s为一个周期进行执行
        //  秒 分 时 日 月 星期   ：而星期这个位置是? 是因为要和你的日匹配上
        // *  * *  *  ?:代表任意时间任意日任意月 不限制星期
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        return TriggerBuilder
                .newTrigger()
                .forJob(printJobDetail())//触发器将绑定工作明细printJobDetail()
                .withSchedule(cronScheduleBuilder)//设定执行工作周期
                .build();
    }

}
