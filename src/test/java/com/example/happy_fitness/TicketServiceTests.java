package com.example.happy_fitness;

import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.entity.Role;
import com.example.happy_fitness.entity.Ticket;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.TicketRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.impl.TicketServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class TicketServiceTests {
    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;

    @Test
    public void checkFindTicketDetailTestcase01(){
        long id = 11;
        Ticket ticket = new Ticket();
        ticket.setFacility(new Facility());
        Mockito.when(ticketRepository.findById(id)).thenReturn(Optional.of(ticket));
        Ticket result = ticketService.findTicketDetail(id);
        Assertions.assertNotNull(result);
    }

    @Test
    public void checkFindTicketDetailTestcase02(){
        long id = 12;
        Mockito.when(ticketRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class , () -> ticketService.findTicketDetail(id));
    }

    @Test
    public void checkDeactiveTestcase01(){
        long id = 11;
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername("abc")
                .roles("CUSTOMER")
                .password("dummyPassword")
                .build();
        User user = new User();
        Ticket ticket = new Ticket();
        Facility facility = new Facility();
        facility.setId(1L);
        ticket.setFacility(facility);
        user.setFacility(facility);
        Mockito.when(ticketRepository.findById(id)).thenReturn(Optional.of(ticket));
        Mockito.when(userRepository.findByUsername(userDetails.getUsername())).thenReturn(user);
        String result = ticketService.deactivate(userDetails , id);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkDeactiveTestcase02(){
        long id = 11;
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername("abc")
                .roles("CUSTOMER")
                .password("dummyPassword")
                .build();
        User user = new User();
        Ticket ticket = new Ticket();
        Facility facility = new Facility();
        facility.setId(1L);
        Facility facility1 = new Facility();
        facility1.setId(2L);
        ticket.setFacility(facility);
        user.setFacility(facility1);
        Mockito.when(ticketRepository.findById(id)).thenReturn(Optional.of(ticket));
        Mockito.when(userRepository.findByUsername(userDetails.getUsername())).thenReturn(user);
        Assertions.assertThrows(RuntimeException.class , () -> ticketService.deactivate(userDetails , id));
    }

    @Test
    public void checkDeactiveTestcase03(){
        long id = 11;
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername("abc")
                .roles("ADMIN")
                .password("dummyPassword")
                .build();
        User user = new User();
        Ticket ticket = new Ticket();
        Facility facility = new Facility();
        facility.setId(1L);
        Facility facility1 = new Facility();
        facility1.setId(2L);
        ticket.setFacility(facility);
        user.setFacility(facility1);
        Mockito.when(ticketRepository.findById(id)).thenReturn(Optional.of(ticket));
        Mockito.when(userRepository.findByUsername(userDetails.getUsername())).thenReturn(user);
        String result = ticketService.deactivate(userDetails , id);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkDeactiveTestcase04(){
        long id = 12;
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername("abc")
                .roles("ADMIN")
                .password("dummyPassword")
                .build();
        Assertions.assertThrows(RuntimeException.class , () -> ticketService.deactivate(userDetails , id));
    }



}
