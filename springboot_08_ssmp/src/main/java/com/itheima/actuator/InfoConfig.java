package com.itheima.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.actuator
 * @Author: ASUS
 * @CreateTime: 2023-07-23  11:27
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        //第一种：传递单个
        builder.withDetail("runTime",System.currentTimeMillis());
        //第二种：传递多个
        Map infoMap=new HashMap<>();
        infoMap.put("buildTime","2006");
        builder.withDetails(infoMap);
    }
}
