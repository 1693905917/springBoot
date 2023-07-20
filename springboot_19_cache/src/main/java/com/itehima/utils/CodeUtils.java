package com.itehima.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {

    private String [] patch = {"000000","00000","0000","000","00","0",""};

    //对于验证码进行加密操作
    public String generator(String telephone){
        int hash = telephone.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        //取后六位
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    @Cacheable(value = "smsCode",key="#telephone")
    public String get(String telephone){
        return null;//这里设置为Null,就不会往里面存储，而是取数据给telephone
    }

//    public static void main(String[] args) {
//        System.out.println(new CodeUtils().generator("18866668888"));
//    }

}
