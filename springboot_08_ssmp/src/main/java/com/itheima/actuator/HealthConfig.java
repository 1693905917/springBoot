package com.itheima.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.actuator
 * @Author: ASUS
 * @CreateTime: 2023-07-23  11:55
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //第一种：传递单个
        builder.withDetail("runTime",System.currentTimeMillis());
        //第二种：传递多个
        Map infoMap=new HashMap<>();
        infoMap.put("buildTime","2006");
        builder.withDetails(infoMap);
        //设置当前组件状态信息:有四种状态信息:
        // up、down、outOfService、unknown 默认是unknown
        //第一种写法：（不推荐）
        //builder.up();
        //第二种写发：（推荐）
        builder.status(Status.UP);
    }
}
