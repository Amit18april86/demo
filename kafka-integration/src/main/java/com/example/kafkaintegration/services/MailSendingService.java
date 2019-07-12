package com.example.kafkaintegration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailSendingService {
    @Autowired
    MailSender mailSender;

    public void sendMailMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("me@gmail.com");
        simpleMailMessage.setTo("me@gmail.com");
        simpleMailMessage.setSubject("This is sample Subject");
        simpleMailMessage.setText("This is sample Text");
        this.mailSender.send(simpleMailMessage);
    }
}
