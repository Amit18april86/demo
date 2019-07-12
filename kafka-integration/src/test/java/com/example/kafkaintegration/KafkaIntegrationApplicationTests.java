package com.example.kafkaintegration;

import com.example.kafkaintegration.services.MailSendingService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaIntegrationApplicationTests {

    @Autowired
    MailSendingService mailSendingService;

    @Test
    public void contextLoads() {
    }

    @Test
    @Ignore
    public void checkSendMail(){
        try{
            this.mailSendingService.sendMailMessage();
            Assert.assertTrue("Mail Sent", true);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Error While Sending mail");
        }
    }
}
