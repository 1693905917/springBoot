package com.example;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.example
 * @Author: ASUS
 * @CreateTime: 2023-07-20  11:38
 * @Description: TODO
 * @Version: 1.0
 */
public class QuartzTaskBean extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz job run...");
    }
}
