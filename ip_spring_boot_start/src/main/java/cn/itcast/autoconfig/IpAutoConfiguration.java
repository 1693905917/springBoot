package cn.itcast.autoconfig;

import cn.itcast.properties.IpProperties;
import cn.itcast.service.IpCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: cn.itcast.autoconfig
 * @Author: ASUS
 * @CreateTime: 2023-07-25  09:30
 * @Description: TODO
 * @Version: 1.0
 */
//将IpCountService注入成bean有两种方法
//第一种：

@EnableScheduling
//放弃配置属性创建bean方式，改为手工控制
//@EnableConfigurationProperties(IpProperties.class)
@Import(IpProperties.class)
public class IpAutoConfiguration {

    //第二种：
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }


}
