package com.example.service.impl;


import com.example.domain.SMSCode;
import com.example.service.SMSCodeService;
import com.example.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
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
    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String telephone) {
        String code = codeUtils.generator(telephone);
        cacheChannel.set("sms",telephone,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=cacheChannel.get("sms",smsCode.getTelephone()).asString();
        return smsCode.getCode().equals(code);
    }

}
