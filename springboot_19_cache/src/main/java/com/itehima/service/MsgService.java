package com.itehima.service;

public interface MsgService {
    //获取手机号信息
    String get(String telephone);
    //验证手机号与验证码匹配
    boolean check(String telephone,String code);
}
