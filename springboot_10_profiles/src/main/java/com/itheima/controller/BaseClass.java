package com.itheima.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.controller
 * @Author: ASUS
 * @CreateTime: 2023-07-13  20:33
 * @Description: TODO
 * @Version: 1.0
 */
public class BaseClass {
    private Class clazz;
    public static Logger log;

    public BaseClass(){
        clazz=this.getClass();
        log= LoggerFactory.getLogger(clazz);
    }

}
