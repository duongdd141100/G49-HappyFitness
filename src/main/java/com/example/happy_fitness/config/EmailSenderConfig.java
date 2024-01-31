package com.example.happy_fitness.config;

import com.example.happy_fitness.common.PropertyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailSenderConfig {
    @Autowired
    private PropertyBean propertyBean;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(propertyBean.getMailHost());
        mailSender.setPort(propertyBean.getMailPort());

        mailSender.setUsername(propertyBean.getMailUsername());
        mailSender.setPassword(propertyBean.getMailPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        return mailSender;
    }
}
