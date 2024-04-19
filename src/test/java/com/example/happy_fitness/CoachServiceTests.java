package com.example.happy_fitness;

import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.impl.CoachServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class CoachServiceTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CoachServiceImpl coachService;

    @Test
    public void checkGetCoachByIdTestcase01(){
        long id = 11;
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(new User()));
        User user = coachService.getCoachById(id);
        Assertions.assertNotNull(user);
    }

    @Test
    public void checkGetCoachByIdTestcase02(){
        long id = 12;
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundExeption.class,() -> coachService.getCoachById(id));

    }
}
