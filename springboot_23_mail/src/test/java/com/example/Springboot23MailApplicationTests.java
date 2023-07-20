package com.example;

import com.example.service.SendMailService;
import com.example.service.SendMimeMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot23MailApplicationTests {
    @Autowired
    private SendMimeMailService sendMimeMailService;

    @Test
    void contextLoads() {
        sendMimeMailService.SendMail();
    }

}
