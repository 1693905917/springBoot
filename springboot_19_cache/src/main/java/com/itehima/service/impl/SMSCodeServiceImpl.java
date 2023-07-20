package com.itehima.service.impl;

import com.itehima.domain.SMSCode;
import com.itehima.service.SMSCodeService;
import com.itehima.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itehima.service
 * @Author: ASUS
 * @CreateTime: 2023-07-19  14:15
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;
    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String telephone) {
        String code = codeUtils.generator(telephone);
        //将数据加入memcache
        try {//memcachedClient.set方法中三个参数：(key,生命周期：0是永久存在,需要存储到key中的数据)
            memcachedClient.set(telephone,0,code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=null;
        try {
            code=memcachedClient.get(smsCode.getTelephone()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }


//    @Override
//    @CachePut(value = "smsCode",key = "#telephone")
//    public String sendCodeToSMS(String telephone) {
//        return codeUtils.generator(telephone);
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        //取出内存中的验证码与传递过来的验证码比对，如果相同，返回true
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.get(smsCode.getTelephone());
//        return code.equals(cacheCode);
//    }
}
