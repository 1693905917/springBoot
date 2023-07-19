package com.itehima.service.impl;

import com.itehima.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itehima.service.impl
 * @Author: ASUS
 * @CreateTime: 2023-07-19  11:06
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String,String> cache=new HashMap<>();

    @Override
    public String get(String telephone) {
        //我们获取手机号后6位来作为验证码
        String code = telephone.substring(telephone.length() - 6);
        cache.put(telephone,code);
        return code;
    }

    @Override
    public boolean check(String telephone, String code) {
        String queryCode = cache.get(telephone);
        return code.equals(queryCode);
    }
}
