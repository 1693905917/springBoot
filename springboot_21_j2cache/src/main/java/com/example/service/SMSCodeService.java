package com.example.service;


import com.example.domain.SMSCode;

public interface SMSCodeService {
    String sendCodeToSMS(String telephone);
    boolean checkCode(SMSCode smsCode);
}
