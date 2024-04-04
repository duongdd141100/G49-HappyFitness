package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.PropertyBean;
import com.example.happy_fitness.constants.Constants;
import com.example.happy_fitness.custom_repository.UserCustomRepository;
import com.example.happy_fitness.dto.UserDto;
import com.example.happy_fitness.entity.MailTemplate;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.MailTemplateRepository;
import com.example.happy_fitness.repository.RoleRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.EmailService;
import com.example.happy_fitness.service.UserService;
import jakarta.mail.MessagingException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserCustomRepository userCustomRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private MailTemplateRepository mailTemplateRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PropertyBean propertyBean;

    @Override
    public List<UserDto> findAllByCondition(String requesterUsername, String username, String fullName, String email, Boolean gender, Float roleId) {
        return userCustomRepo.findAllByCondition(
                userRepo.findByUsername(requesterUsername), username, fullName, email, gender, roleId);
    }

    @Override
    public User create(String creatorUsername, User user) {
        User creator = userRepo.findByUsername(creatorUsername);
        if (Constants.MANAGER_ROLE.equalsIgnoreCase(creator.getRole().getName())) {
            if (Stream.of(Constants.ADMIN_ROLE, Constants.MANAGER_ROLE, Constants.CUSTOMER_ROLE)
                    .anyMatch(roleRepo.findById(user.getRole().getId()).get().getName()::equalsIgnoreCase)) {
                throw new AccessDeniedException(ErrorMessageEnum.ERROR_CREATE_NEW_USER_BECAUSE_ROLE.getCode());
            }
            if (!creator.getFacility().getId().equals(user.getFacility().getId())) {
                throw new AccessDeniedException(ErrorMessageEnum.ERROR_CREATE_NEW_USER_BECAUSE_FACILITY.getCode());
            }
        }
        if (Stream.of(user.getFullName(),
                user.getUsername(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getEmail()).allMatch(StringUtils::hasText)
                && user.getGender() != null
                && user.getDob() != null
                && user.getRole().getId() != null) {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                throw new RuntimeException(ErrorMessageEnum.USERNAME_EXIST.getCode());
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
        throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
    }

    @Override
    public UserDto findUserDetail(UserDetails userDetails, String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new RuntimeException(ErrorMessageEnum.USERNAME_NOT_EXIST.getCode());
        }
        User requester = userRepo.findByUsername(userDetails.getUsername());
        if (Constants.MANAGER_ROLE.equalsIgnoreCase(requester.getRole().getName())
                && (user.getFacility() == null
                || !requester.getFacility().getId().equals(user.getFacility().getId()))) {
            throw new AccessDeniedException(ErrorMessageEnum.ACCESS_DENIED_VIEW_USER_DETAIL.getCode());
        }

        return Optional.of(user).map(x -> new UserDto(x.getId(), x.getUsername(), x.getFullName(),
                x.getEmail(), x.getGender(), x.getDob(), x.getPhoneNumber(),
                x.getAddress(), x.getFacility() != null ? x.getFacility().getName() : null, x.getRole().getName())).orElseThrow(() -> new RuntimeException(ErrorMessageEnum.USERNAME_NOT_EXIST.getCode()));
    }

    @Override
    public String resetPassword(UserDetails userDetails, String username) throws MessagingException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new RuntimeException(ErrorMessageEnum.USERNAME_NOT_EXIST.getCode());
        }
        User requester = userRepo.findByUsername(userDetails.getUsername());
        if (Constants.MANAGER_ROLE.equalsIgnoreCase(requester.getRole().getName())
                && (user.getFacility() == null
                || !requester.getFacility().getId().equals(user.getFacility().getId()))) {
            throw new AccessDeniedException(ErrorMessageEnum.ACCESS_DENIED_RESET_PASSWORD.getCode());
        }
        String passRandom = RandomStringUtils.random(8, true, true);
        MailTemplate mailTemplate = mailTemplateRepo.findByCode(propertyBean.getResetPasswordTemplateCode());
        emailService.send(user.getEmail(), mailTemplate.getSubject(), String.format(mailTemplate.getContent(), passRandom), new MultipartFile[]{});
        user.setPassword(passwordEncoder.encode(passRandom));
        userRepo.save(user);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String deactivate(UserDetails userDetails, String username) {
        if (userDetails.getUsername().equals(username)) {
            throw new AccessDeniedException(ErrorMessageEnum.CANNOT_DEACTIVATE_YOUR_SELF.getCode());
        }
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new RuntimeException(ErrorMessageEnum.USERNAME_NOT_EXIST.getCode());
        }
        User requester = userRepo.findByUsername(userDetails.getUsername());
        if (Constants.MANAGER_ROLE.equalsIgnoreCase(requester.getRole().getName())
                && (user.getFacility() == null
                || !requester.getFacility().getId().equals(user.getFacility().getId()))) {
            throw new AccessDeniedException(ErrorMessageEnum.ACCESS_DENIED_DEACTIVATE_USER.getCode());
        }
        user.setStatus(false);
        userRepo.save(user);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public User create(UserDetails userDetails, User user) {
        return null;
    }

    @Override
    public String update(User user, Float id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Float> id) {

    }
}
