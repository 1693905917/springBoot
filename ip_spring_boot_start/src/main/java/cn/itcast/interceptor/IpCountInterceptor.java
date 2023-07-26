package cn.itcast.interceptor;

import cn.itcast.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: cn.itcast.interceptor
 * @Author: ASUS
 * @CreateTime: 2023-07-25  11:41
 * @Description: TODO
 * @Version: 1.0
 */
public class IpCountInterceptor implements HandlerInterceptor {
    @Autowired
    private IpCountService ipCountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCountService.count();
        return true;
    }
}
