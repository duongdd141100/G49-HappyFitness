package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.constants.Constants;
import com.example.happy_fitness.entity.Facility;
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

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String create(UserDetails userDetails, Ticket ticket) {
        if (RoleEnum.ROLE_ADMIN.name().equals(userDetails.getAuthorities().stream().findFirst().get().getAuthority())) {
            if (ticket.getFacility() == null || ticket.getFacility().getId() == null) {
                throw new RuntimeException(ErrorMessageEnum.FACILITY_EMPTY.getCode());
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATETIME_YYYY_MM_DD_HH_MM_SS_SSS);
        ticket.setCode("P_" + formatter.format(new Date()));
        ticket.setFacility(facilityRepo.findById(ticket.getFacility().getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.FACILITY_NOT_EXIST.getCode())));
        ticket.setStatus(true);
        ticketRepo.save(ticket);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String update(Ticket ticket, Long id, UserDetails userDetails) {
        Ticket ticketOrigin = ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.TICKET_NOT_EXIST.getCode()));
        ticketOrigin.setName(ticket.getName());
        ticketOrigin.setPrice(ticket.getPrice());
        ticketOrigin.setDescription(ticket.getDescription());
        ticketOrigin.setMonthDuration(ticket.getMonthDuration());
        ticketRepo.save(ticketOrigin);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public List<Ticket> findAllByFacilityId(Long facilityId) {
        return (facilityId == null
                ? ticketRepo.findAll()
                : ticketRepo.findAllByFacility_Id(facilityId))
                .stream().map(x -> {
            x.getFacility().setManager(null);
            return x;
        }).toList();
    }

    @Override
    public Ticket findTicketDetail(Long id) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new RuntimeException(ErrorMessageEnum.TICKET_NOT_EXIST.getCode()));
        ticket.getFacility().setManager(null);
        return ticket;
    }

    @Override
    public String deactivate(UserDetails userDetails, Long id) {
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
