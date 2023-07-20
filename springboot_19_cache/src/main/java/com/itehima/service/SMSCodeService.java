package com.itehima.service;

import com.itehima.domain.SMSCode;

public interface SMSCodeService {
    String sendCodeToSMS(String telephone);
    boolean checkCode(SMSCode smsCode);
}
