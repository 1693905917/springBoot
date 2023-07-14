package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.controller.utils
 * @Author: ASUS
 * @CreateTime: 2023-07-11  09:50
 * @Description: TODO
 * @Version: 1.0
 */
//作为springmvc的异常处理器
//@Controller
@RestControllerAdvice
public class ProjectExceptionAdvice {
        //拦截所有的异常信息，并且全部封装到Exception e中
        @ExceptionHandler
        public R doException(Exception e){
            //注意：当异常抛出以后，这里会帮你隐藏异常，让你没办法发现：
            // 所以要添加：e.printStackTrace()就可以在控制台上看见异常信息
            e.printStackTrace();
            return new R(false,"系统错误，请稍后再试！");
        }
}
