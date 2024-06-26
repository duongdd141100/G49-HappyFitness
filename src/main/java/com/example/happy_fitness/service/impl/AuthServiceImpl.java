package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.PropertyBean;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.MailTemplate;
import com.example.happy_fitness.entity.Role;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.MailTemplateRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.AuthService;
import com.example.happy_fitness.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailTemplateRepository mailTemplateRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PropertyBean propertyBean;

    public static final Integer MAX_CODE = 999999;
    @Override
    public UserDetails validateUser(User user) {
        if (user != null && StringUtils.hasText(user.getUsername())) {
            User realUser = userRepo.findByUsername(user.getUsername());
            if (passwordEncoder.matches(CharBuffer.wrap(user.getPassword()), realUser.getPassword())) {
                return org.springframework.security.core.userdetails.User
                        .withUsername(realUser.getUsername())
                        .password(realUser.getPassword())
                        .roles(realUser.getRole().getName().toUpperCase().replaceAll(" ", "_"))
                        .build();
            }
        }
        throw new RuntimeException(ErrorMessageEnum.LOGIN_FAILED.getCode());
    }

    @Override
    public User findByUsername(String issuer) {
        if (StringUtils.hasText(issuer)) {
            User user = userRepo.findByUsername(issuer);
            if (user.getFacility() != null) {
                user.getFacility().getManager().getFacility().setManager(null);
            }
            return user;
        }
        throw new RuntimeException(ErrorMessageEnum.TOKEN_INVALID.getCode());
    }

    @Override
    public User save(User user) {
        if (Arrays.asList(user.getFullName(),
                user.getUsername(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getEmail()).stream().allMatch(StringUtils::hasText)
                && user.getGender() != null
                && user.getDob() != null) {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                throw new RuntimeException(ErrorMessageEnum.USERNAME_EXIST.getCode());
            }
            if (!Pattern.compile("^[A-Za-z]\\w{5,29}$").matcher(user.getUsername()).matches()) {
                throw new RuntimeException(ErrorMessageEnum.USERNAME_INVALID.getCode());
            }
            String phoneNumber = user.getPhoneNumber().trim();
            if (phoneNumber.length() < 10
                    || !Pattern.compile("\\d+").matcher(phoneNumber).matches()) {
                throw new RuntimeException(ErrorMessageEnum.PHONE_NUMBER_INVALID.getCode());
            }
            Role role = new Role();
            role.setId(RoleEnum.ROLE_CUSTOMER.getId());
            user.setUsername(user.getUsername().toLowerCase());
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEmail(user.getEmail().toLowerCase());
            user.setPhoneNumber(phoneNumber);
            return userRepo.save(user);
        }
        throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
    }

    @Override
    public User editProfile(User user, User newUser) {
        user.setFullName(newUser.getFullName());
        user.setGender(newUser.getGender());
        user.setDob(newUser.getDob());
        user.setAddress(newUser.getAddress());
        user.setPhoneNumber(newUser.getPhoneNumber());
        return userRepo.save(user);
    }

    @Override
    public String changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String forgetPassword(String email) throws MessagingException {
        if (!userRepo.existsByEmail(email)) {
            throw new RuntimeException(ErrorMessageEnum.EMAIL_NOT_EXIST.getCode());
        }
        MailTemplate mailTemplate = mailTemplateRepo.findByCode(propertyBean.getForgetPasswordTemplateCode());
        Random random = new Random();
        String code = String.format("%06d", random.nextInt(MAX_CODE));
        emailService.send(new String[]{email}, mailTemplate.getSubject(), String.format(mailTemplate.getContent(), code), new MultipartFile[]{});
        return code;
    }
}
