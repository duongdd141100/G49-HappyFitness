package com.example.happy_fitness;


import com.example.happy_fitness.common.PropertyBean;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.entity.MailTemplate;
import com.example.happy_fitness.entity.Role;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.MailTemplateRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.impl.AuthServiceImpl;
import com.example.happy_fitness.service.impl.EmailServiceImpl;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.CharBuffer;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class AuthServiceTests {

    @Mock
    private UserRepository userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private PropertyBean propertyBean;

    @Mock
    private EmailServiceImpl emailService;

    @Mock
    private MailTemplateRepository mailTemplateRepository;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // Optional: Configure mock behavior if needed
    }


    @Test
    public void checkValidateUserTestcase01(){
        User user = null;
        Assertions.assertThrows(RuntimeException.class ,() -> authService.validateUser(user));
    }

    @Test
    public void checkValidateUserTestcase02(){
        User user = new User();
        String username = "user1";
        user.setUsername(username);
        String password = "123456";
        user.setPassword(password);

        String hasedPassword = "hasedPassword";
        User returnedUser = new User();
        Role role = new Role();
        role.setName(RoleEnum.ROLE_ADMIN.getValue());
        returnedUser.setUsername(username);
        returnedUser.setPassword(hasedPassword);
        returnedUser.setRole(role);

        Mockito.when(passwordEncoder.matches(CharBuffer.wrap(user.getPassword()), returnedUser.getPassword())).thenReturn(false);
        Mockito.when(userRepo.findByUsername(username)).thenReturn(returnedUser);
        Assertions.assertThrows(RuntimeException.class ,() -> authService.validateUser(user));
    }

    @Test
    public void checkValidateUserTestcase03(){
        User user = new User();
        String username = "user1";
        user.setUsername(username);
        String password = "12345";
        user.setPassword(password);

        String hasedPassword = "hasedPassword";
        User returnedUser = new User();
        Role role = new Role();
        role.setName(RoleEnum.ROLE_ADMIN.getValue());
        returnedUser.setUsername(username);
        returnedUser.setPassword(hasedPassword);
        returnedUser.setRole(role);

        Mockito.when(passwordEncoder.matches(CharBuffer.wrap(user.getPassword()), returnedUser.getPassword())).thenReturn(true);
        Mockito.when(userRepo.findByUsername(username)).thenReturn(returnedUser);
        UserDetails userDetails = authService.validateUser(user);
        Assertions.assertTrue(userDetails != null);
    }

    @Test
    public void checkFindByUsernameTestcase01(){
        String issuer = null;
        Assertions.assertThrows(RuntimeException.class ,() -> authService.findByUsername(issuer));
    }

    @Test
    public void checkFindByUsernameTestcase02(){
        String issuer = "user1";
        User user = new User();
        Facility userFacility = new Facility();
        userFacility.setManager(new User());
        user.setFacility(userFacility);
        Mockito.when(userRepo.findByUsername(issuer)).thenReturn(user);
        User returnedUser = authService.findByUsername(issuer);
        Assertions.assertNotNull(returnedUser);
    }

    @Test
    public void checkSaveTestcase01(){
        User user = new User();
        user.setUsername("user1");
        user.setPassword("12345");
        user.setFullName("");
        user.setPhoneNumber("098");
        user.setAddress("12");
        user.setEmail("abc@gmail.com");
        user.setGender(true);
        user.setDob(new Date());
        Assertions.assertThrows(RuntimeException.class ,() -> authService.save(user));
    }

    @Test
    public void checkSaveTestcase02(){
        User user = new User();
        user.setUsername("user1");
        user.setPassword("12345");
        user.setFullName("name");
        user.setPhoneNumber("098");
        user.setAddress("12");
        user.setEmail("abc@gmail.com");
        user.setGender(true);
        user.setDob(new Date());
        Mockito.when(userRepo.findByUsername(user.getUsername())).thenReturn(user);
        Assertions.assertThrows(RuntimeException.class ,() -> authService.save(user));
    }

    @Test
    public void checkSaveTestcase03(){
        User user = new User();
        user.setUsername("user123");
        user.setPassword("12345");
        user.setFullName("name");
        user.setPhoneNumber("098");
        user.setAddress("12");
        user.setEmail("abc@gmail.com");
        user.setGender(true);
        user.setDob(new Date());
        Mockito.when(userRepo.findByUsername(user.getUsername())).thenReturn(null);
        Mockito.when(userRepo.save(user)).thenReturn(user);
        User returnedUser = authService.save(user);
        Assertions.assertNotNull(returnedUser);
    }

    @Test
    public void checkForgetPasswordTestcase01(){
        String email = "";
        Mockito.when(userRepo.existsByEmail(email)).thenReturn(false);
        Assertions.assertThrows(RuntimeException.class ,() -> authService.forgetPassword(email));
    }

    @Test
    public void checkForgetPasswordTestcase02(){
        String email = "abc@gmail.com";
        String templateCode = "";
        MailTemplate mailTemplate = new MailTemplate();
        mailTemplate.setContent("");
        Mockito.when(userRepo.existsByEmail(email)).thenReturn(true);
        Mockito.when(propertyBean.getForgetPasswordTemplateCode()).thenReturn(templateCode);
        Mockito.when(mailTemplateRepository.findByCode(templateCode)).thenReturn(mailTemplate);
        try {
            String message = authService.forgetPassword(email);
            Assertions.assertNotNull(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void checkEditProfileTestcase01(){
        User user = new User();
        user.setUsername("user1");
        user.setPassword("12345");
        user.setFullName("name1");
        user.setPhoneNumber("098");
        user.setAddress("12");
        user.setEmail("abc@gmail.com");
        user.setGender(true);
        user.setDob(new Date());

        User newUser = new User();
        newUser.setUsername("user1");
        newUser.setPassword("12345");
        newUser.setFullName("name2");
        newUser.setPhoneNumber("098");
        newUser.setAddress("12");
        newUser.setEmail("abc@gmail.com");
        newUser.setGender(true);
        newUser.setDob(new Date());
        Mockito.when(userRepo.save(user)).thenReturn(user);
        User returnedUser = authService.editProfile(user , newUser);
        Assertions.assertEquals(newUser.getFullName() , returnedUser.getFullName());
    }

    @Test
    public void checkChangePasswordTestcase01(){
        String newPass = "123";
        User user = new User();
        String message = authService.changePassword(user , newPass);
        Assertions.assertEquals(message , HttpStatus.OK.getReasonPhrase());
    }




}
