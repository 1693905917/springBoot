package com.itheima.service.impl.base;

import com.itheima.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl
 * @Author: ASUS
 * @CreateTime: 2023-07-22  09:59
 * @Description: TODO
 * @Version: 1.0
 */
//@Service
public class MessageServiceImpl implements MessageService {
    private ArrayList<String> msgList=new ArrayList<>();

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列,id:"+id);
        msgList.add(id);
    }

    @Override
    public String doMessage() {
        String id = msgList.remove(0);
        System.out.println("已完成短信发送业务，id:"+id);
        return id;
    }
}
