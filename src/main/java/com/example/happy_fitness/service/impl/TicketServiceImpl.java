package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.Ticket;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.FacilityRepository;
import com.example.happy_fitness.repository.TicketRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepo;

    @Autowired
    private FacilityRepository facilityRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Ticket create(UserDetails userDetails, Ticket ticket) {
        if (RoleEnum.ROLE_ADMIN.name().equals(userDetails.getAuthorities().stream().findFirst().get().getAuthority())) {
            if (ticket.getFacility() == null || ticket.getFacility().getId() == null) {
                throw new RuntimeException(ErrorMessageEnum.FACILITY_EMPTY.getCode());
            } else {
                if (!facilityRepo.existsById(ticket.getFacility().getId())) {
                    throw new RuntimeException(ErrorMessageEnum.FACILITY_NOT_EXIST.getCode());
                }
            }
        } else {
            ticket.setFacility(userRepo.findByUsername(userDetails.getUsername()).getFacility());
        }
        return ticketRepo.save(ticket);
    }

    @Override
    public String update(Ticket ticket, Float id) {
        return null;
    }

    @Override
    public void delete(List<Float> ids) {

    }

    @Override
    public List<Ticket> findAllByFacilityId(Float facilityId) {
        return ticketRepo.findAllByFacility_Id(facilityId).stream().map(x -> {
            x.setFacility(null);
            return x;
        }).toList();
    }

    @Override
    public Ticket findTicketDetail(Float id) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new RuntimeException(ErrorMessageEnum.TICKET_NOT_EXIST.getCode()));
        ticket.getFacility().setManager(null);
        return ticket;
    }

    @Override
    public String deactivate(UserDetails userDetails, Float id) {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.TICKET_NOT_EXIST.getCode()));
        if (RoleEnum.ROLE_ADMIN.name().equals(userDetails.getAuthorities().stream().findFirst().get().getAuthority())) {
            ticket.setStatus(false);
        } else {
            User user = userRepo.findByUsername(userDetails.getUsername());
            if (!user.getFacility().getId().equals(ticket.getFacility().getId())) {
                throw new RuntimeException(ErrorMessageEnum.CANNOT_DEACTIVATE_TICKET.getCode());
            }
            ticket.setStatus(false);
        }
        return HttpStatus.OK.getReasonPhrase();
    }
}
