package com.itheima.controller;


import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itehima.controller
 * @Author: ASUS
 * @CreateTime: 2023-07-19  14:16
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String telephone){
        String code = smsCodeService.sendCodeToSMS(telephone);
        return code;
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode){
        return smsCodeService.checkCode(smsCode);
    }
}
