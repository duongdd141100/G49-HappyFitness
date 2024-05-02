package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.CustomerTickeActionEnum;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.*;
import com.example.happy_fitness.repository.CustomerTicketRepository;
import com.example.happy_fitness.repository.TicketRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.repository.VoucherRepository;
import com.example.happy_fitness.service.CustomerTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class CustomerTicketServiceImpl implements CustomerTicketService {
    @Autowired
    private CustomerTicketRepository customerTicketRepo;

    @Autowired
    private VoucherRepository voucherRepo;

    @Autowired
    private TicketRepository ticketRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public String create(UserDetails userDetails, CustomerTicket customerTicket) {
        return null;
    }

    @Override
    public String update(CustomerTicket customerTicket, Long id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public CustomerTicket extend(Long id, String voucherCode) {
        CustomerTicket customerTicket = customerTicketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.TICKET_NOT_EXIST.getCode()));
        if (customerTicket.getStatus()) {
            throw new RuntimeException(ErrorMessageEnum.TICKET_UNEXPIRED.getCode());
        }
        if (!CollectionUtils.isEmpty(customerTicketRepo.findAllByCustomer_IdAndStatusIsTrue(customerTicket.getCustomer().getId()))) {
            throw new RuntimeException(ErrorMessageEnum.HAS_TICKET_ACTIVE.getCode());
        }
        Voucher voucher = null;
        if (StringUtils.hasText(voucherCode)) {
            voucher = voucherRepo.findByCode(voucherCode)
                    .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_EXIST.getCode()));
            Date now = new Date();
            if (voucher.getStartDate().after(now) || voucher.getEndDate().before(now)) {
                throw new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_VALID.getCode());
            }
        }
        CustomerTicket newCustomerTicket = new CustomerTicket();
        LocalDate localEndDate = LocalDate.now().plusMonths(customerTicket.getTicket().getMonthDuration());
        newCustomerTicket.setCustomer(customerTicket.getCustomer());
        newCustomerTicket.setTicket(customerTicket.getTicket());
        newCustomerTicket.setStatus(false);
        newCustomerTicket.setPaid(false);
        newCustomerTicket.setStartDate(new Date());
        newCustomerTicket.setEndDate(Date.from(localEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        newCustomerTicket.setAction(CustomerTickeActionEnum.EXTEND.name());
        newCustomerTicket.setVoucher(voucher);
        Float price = customerTicket.getTicket().getPrice();
        if (voucher != null) {
            Float discount = price * voucher.getPercentAmount() / 100;
            newCustomerTicket.setPrice(discount > voucher.getMaxMoneyAmount()
                    ? price - voucher.getMaxMoneyAmount()
                    : price - discount);
        } else {
            newCustomerTicket.setPrice(price);
        }
        newCustomerTicket = customerTicketRepo.save(newCustomerTicket);
        newCustomerTicket.getTicket().setFacility(null);
        return newCustomerTicket;
    }

    @Override
    public CustomerTicket buy(Long id, String voucherCode, UserDetails userDetails) {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.TICKET_NOT_EXIST.getCode()));
        User user = userRepo.findByUsername(userDetails.getUsername());
        if (!CollectionUtils.isEmpty(customerTicketRepo.findAllByCustomer_IdAndStatusIsTrue(user.getId()))) {
            throw new RuntimeException(ErrorMessageEnum.HAS_TICKET_ACTIVE.getCode());
        }
        Voucher voucher = null;
        if (StringUtils.hasText(voucherCode)) {
            voucher = voucherRepo.findByCode(voucherCode)
                    .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_EXIST.getCode()));
            Date now = new Date();
            if (voucher.getStartDate().after(now) || voucher.getEndDate().before(now)) {
                throw new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_VALID.getCode());
            }
        }
        CustomerTicket newCustomerTicket = new CustomerTicket();
        LocalDate localEndDate = LocalDate.now().plusMonths(ticket.getMonthDuration());
        newCustomerTicket.setCustomer(user);
        newCustomerTicket.setTicket(ticket);
        newCustomerTicket.setStatus(false);
        newCustomerTicket.setStartDate(new Date());
        newCustomerTicket.setEndDate(Date.from(localEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        newCustomerTicket.setAction(CustomerTickeActionEnum.BUY_NEW.name());
        newCustomerTicket.setVoucher(voucher);
        newCustomerTicket.setPaid(false);
        Float price = ticket.getPrice();
        if (voucher != null) {
            Float discount = price * voucher.getPercentAmount() / 100;
            newCustomerTicket.setPrice(discount > voucher.getMaxMoneyAmount()
                    ? price - voucher.getMaxMoneyAmount()
                    : price - discount);
        } else {
            newCustomerTicket.setPrice(price);
        }
        newCustomerTicket = customerTicketRepo.save(newCustomerTicket);
        newCustomerTicket.getTicket().setFacility(null);
        return newCustomerTicket;
    }

    @Override
    public List<CustomerTicket> findByUsername(UserDetails userDetails, Long facilityId, Boolean isActive, Boolean isUsing) {
        List<CustomerTicket> customerTickets = null;
        String requesterRole = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        if (RoleEnum.ROLE_ADMIN.name().equals(requesterRole)) {
            customerTickets = customerTicketRepo.findAll();
        } else if (Arrays.asList(RoleEnum.ROLE_MANAGER.name(), RoleEnum.ROLE_RECEPTIONIST.name()).contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            customerTickets = customerTicketRepo.findAllByTicket_FacilityOrderByUpdatedDateDesc(requester.getFacility());
        } else if (RoleEnum.ROLE_CUSTOMER.name().contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            customerTickets = customerTicketRepo.findAllByCustomer_UsernameOrderByUpdatedDateDesc(requester.getUsername());
        } else {
            return new ArrayList<>();
        }
        if (facilityId != null) {
            customerTickets = customerTickets.stream()
                    .filter(x -> x.getTicket().getFacility().getId().equals(facilityId)).toList();
        }
        if (isActive != null) {
            customerTickets = customerTickets.stream()
                    .filter(x -> x.getStatus().equals(isActive)).toList();
        }
        if (isUsing != null) {
            customerTickets = customerTickets.stream()
                    .filter(x -> x.getStatus().equals(isUsing)).toList();
        }
//        customerTickets.sort(Comparator.comparing(CustomerTicket::getStatus, Comparator.reverseOrder()));
        return customerTickets.stream().map(x -> {
            x.getTicket().getFacility().setManager(null);
            return x;
        }).toList();
    }

    @Override
    public String using(String customerUsername) {
        CustomerTicket customerTicket = customerTicketRepo.findByCustomer_UsernameAndStatusIsTrue(customerUsername);
        customerTicket.setIsUsing(!customerTicket.getIsUsing());
        customerTicketRepo.save(customerTicket);
        return HttpStatus.OK.getReasonPhrase();
    }
}
