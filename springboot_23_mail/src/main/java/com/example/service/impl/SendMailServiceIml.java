package com.example.service.impl;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.example.service
 * @Author: ASUS
 * @CreateTime: 2023-07-20  15:29
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class SendMailServiceIml implements SendMailService {
    private String from="1693905917@qq.com";//发送人
    private String To="m15270673628@163.com";//接收人
    private String subject="测试邮件主题";
    private String text="测试邮件正文";

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void SendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from+"(张三)");
        mailMessage.setTo(To);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
    }
}
