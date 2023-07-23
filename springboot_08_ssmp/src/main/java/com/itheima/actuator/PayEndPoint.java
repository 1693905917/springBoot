package com.itheima.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.actuator
 * @Author: ASUS
 * @CreateTime: 2023-07-23  14:05
 * @Description: TODO
 * @Version: 1.0
 */
@Component
//id：给你自定义的端点取个名字  enableByDefault：开启你这个端点
@Endpoint(id="pay",enableByDefault = true)
public class PayEndPoint {

    @ReadOperation
    //@ReadOperation:在调用id="pay"的端点需要指明用什么方法或者操作
    public Object getPay(){
        //调用业务操作，获取支付相关信息结果，最终return出去
        Map payMap = new HashMap();
        payMap.put("level 1",103);
        payMap.put("level 2",315);
        payMap.put("level 3",666);
        return payMap;//会将数据以JSON形式传出
    }

}
