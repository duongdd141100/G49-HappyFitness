package com.example.happy_fitness;

import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.FacilityRepository;
import com.example.happy_fitness.service.impl.FacilityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class FacilityServiceTests {
    @Mock
    private FacilityRepository facilityRepository;

    @InjectMocks
    private FacilityServiceImpl facilityService;

    @Test
    public void checkCreateFacilityTestcase01(){
        Facility facility = new Facility();
        facility.setName("name");
        Mockito.when(facilityRepository.save(facility)).thenReturn(facility);
        String result = facilityService.create(null , facility);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkFindAllFacilityTestcase01(){
        Facility facility = new Facility();
        facility.setName("name");
        List<Facility> facilities = Arrays.asList(facility);
        Mockito.when(facilityRepository.findAll()).thenReturn(facilities);
        List<Facility> result = facilityService.findAll();
        Assertions.assertEquals(facilities.size() , result.size());
    }

    @Test
    public void checkFindFacilityByIdTestcase01(){
        long id = 11;
        Mockito.when(facilityRepository.findById(id)).thenReturn(Optional.of(new Facility()));
        Facility facility = facilityService.findById(id);
        Assertions.assertNotNull(facility);
    }

    @Test
    public void checkFindFacilityByIdTestcase02(){
        long id = 12;
        Mockito.when(facilityRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundExeption.class , () -> facilityService.findById(id));
    }

    @Test
    public void checkUpdateFacilityTestcase01(){
        long id = 11;
        Facility updateFacility = new Facility();
        updateFacility.setName("abc1");
        Facility facilityInDb = new Facility();
        facilityInDb.setName("abc");
        Mockito.when(facilityRepository.findById(id)).thenReturn(Optional.of(facilityInDb));
        String result = facilityService.update(updateFacility , id , null);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkUpdateFacilityTestcase02(){
        long id = 12;
        Mockito.when(facilityRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class , () -> facilityService.update(null , id , null));
    }



}
