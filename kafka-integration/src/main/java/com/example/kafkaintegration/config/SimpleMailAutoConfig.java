package com.example.kafkaintegration.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.cloud.aws.mail.simplemail.SimpleEmailServiceMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

@Configuration
public class SimpleMailAutoConfig {
    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService(AWSCredentialsProvider awsCredentialsProvider) {
        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(awsCredentialsProvider).withRegion(Regions.US_EAST_1).build();

    }

    @Bean
    public MailSender mailSender(AmazonSimpleEmailService ases) {
        return new SimpleEmailServiceMailSender(ases);
    }
}
