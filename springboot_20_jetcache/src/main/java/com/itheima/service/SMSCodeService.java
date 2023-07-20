package com.itheima.service;


import com.itheima.domain.SMSCode;

public interface SMSCodeService {
    String sendCodeToSMS(String telephone);
    boolean checkCode(SMSCode smsCode);
}
