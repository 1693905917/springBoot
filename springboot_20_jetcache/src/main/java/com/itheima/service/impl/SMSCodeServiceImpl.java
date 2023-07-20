package com.itheima.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    @CreateCache(area ="default" ,cacheType = CacheType.LOCAL,name = "jetCache", expire = 3600,timeUnit = TimeUnit.SECONDS)
    private Cache<String, String> jetSMSCache;

    @Override
    public String sendCodeToSMS(String telephone) {
        String code = codeUtils.generator(telephone);
        //在default的远程缓存中的名叫jetCache的缓存空间中存放了一个key为telephone的code数据
        jetSMSCache.put(telephone,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=jetSMSCache.get(smsCode.getTelephone());
        return smsCode.getCode().equals(code);
    }

}
