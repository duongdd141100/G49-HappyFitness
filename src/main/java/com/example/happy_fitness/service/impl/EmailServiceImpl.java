package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.PropertyBean;
import com.example.happy_fitness.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PropertyBean propertyBean;

    @Override
    public void send(String to, String subject, String content, MultipartFile... attachFile) throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(propertyBean.getMailFrom());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            for (MultipartFile file : attachFile) {
                helper.addAttachment(file.getOriginalFilename(), file);
            }
            mailSender.send(message);
        } catch (Exception e) {
            throw new MessagingException(ErrorMessageEnum.SEND_MAIL_FAILED.getCode());
        }
    }
}
