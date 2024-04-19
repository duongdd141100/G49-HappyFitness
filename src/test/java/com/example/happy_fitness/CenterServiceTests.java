package com.example.happy_fitness;

import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.repository.FacilityRepository;
import com.example.happy_fitness.service.impl.CenterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class CenterServiceTests {
    @Mock
    private FacilityRepository facilityRepository;

    @InjectMocks
    private CenterServiceImpl centerService;

    @Test
    public void checkGetAllCenterTestcase01(){
        Facility facility = new Facility();
        facility.setName("abc");
        List<Facility> list = Arrays.asList(facility);
        Mockito.when(facilityRepository.findAll()).thenReturn(list);
        List<Facility> result = centerService.getAllCenter();
        Assertions.assertEquals(result.size() , list.size());
    }
}
