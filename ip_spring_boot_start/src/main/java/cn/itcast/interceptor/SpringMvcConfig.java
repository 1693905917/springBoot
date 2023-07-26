package cn.itcast.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: cn.itcast.interceptor
 * @Author: ASUS
 * @CreateTime: 2023-07-25  11:44
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Bean
    public IpCountInterceptor interceptor(){
        return new IpCountInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(interceptor()).addPathPatterns("/**");
    }
}
