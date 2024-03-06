package com.example.happy_fitness.task;

import com.example.happy_fitness.entity.CustomerTicket;
import com.example.happy_fitness.repository.CustomerTicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class TicketRunnable {
    @Autowired
    private CustomerTicketRepository customerTicketRepo;

    public void expire() {
        List<CustomerTicket> customerTickets = customerTicketRepo.findAllByStatusIsTrue();
        customerTickets.forEach(x -> {
            if (x.getEndDate().before(new Date())) {
                x.setStatus(false);
            }
        });
        customerTicketRepo.saveAll(customerTickets);
    }
}
