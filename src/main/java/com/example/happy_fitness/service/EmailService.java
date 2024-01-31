package com.example.happy_fitness.service;

import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    void send(String to, String subject, String content, MultipartFile... attachFile) throws MessagingException;
}
