package com.example.service.impl;

import com.example.service.SendMailService;
import com.example.service.SendMimeMailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.example.service
 * @Author: ASUS
 * @CreateTime: 2023-07-20  15:29
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class SendMimeMailServiceIml implements SendMimeMailService {
    private String from="1693905917@qq.com";//发送人
    private String To="m15270673628@163.com";//接收人
    private String subject="测试邮件主题";
    private String text = "<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F3660fb05-8f3a-4c20-a290-bb9a7af75cb1%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1692434534&t=873a798ad5ef7abbf9f51b59491de9b6'/><a href='https://www.itcast.cn/'>传智教育</a>";

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void SendMail() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            //当需要上传多个部件时，要将MimeMessageHelper(mimeMessage,true);的第二个参数设置为ture，默认是false。
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from+"(张三)");
            helper.setTo(To);
            helper.setSubject(subject);
            //加上true，将含有html标签的元素进行解析  默认是false
            helper.setText(text,true);
            //添加附件
            File file1 = new File("E:\\Java\\IDEA_Practice\\springBoot\\springboot_23_mail\\target\\springboot_23_mail-0.0.1-SNAPSHOT.jar");
            File file2 = new File("E:\\Java\\IDEA_Practice\\springBoot\\springboot_23_mail\\src\\main\\resources\\picture.jpg");
            //helper.addAttachment的一个参数：给上传的附件取个名  第二个参数：需要上传哪个附件
            helper.addAttachment(file1.getName(),file1);
            helper.addAttachment("picture.jpg",file2);

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
