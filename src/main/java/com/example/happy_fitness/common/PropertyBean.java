package com.example.happy_fitness.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class PropertyBean {
    private final String mailHost;
    private final Integer mailPort;
    private final String mailUsername;
    private final String mailPassword;
    private final String mailFrom;
    private final String forgetPasswordTemplateCode;

    @Autowired
    public PropertyBean(@Value("${mail.host}") String mailHost,
                        @Value("${mail.port}") Integer mailPort,
                        @Value("${mail.username}") String mailUsername,
                        @Value("${mail.password}") String mailPassword,
                        @Value("${mail.from}") String mailFrom,
                        @Value("${mail.template.forget-password.code}") String forgetPasswordTemplateCode) {
        this.mailHost = mailHost;
        this.mailPort = mailPort;
        this.mailUsername = mailUsername;
        this.mailPassword = mailPassword;
        this.mailFrom = mailFrom;
        this.forgetPasswordTemplateCode = forgetPasswordTemplateCode;
    }

}
