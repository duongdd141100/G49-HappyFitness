package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.Constants;
import com.example.happy_fitness.entity.Voucher;
import com.example.happy_fitness.repository.VoucherRepository;
import com.example.happy_fitness.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepo;

    @Override
    public String create(UserDetails userDetails, Voucher voucher) {
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATETIME_YYYY_MM_DD_HH_MM_SS_SSS);
        voucher.setCode("VOUCHER_" + formatter.format(new Date()));
        voucherRepo.save(voucher);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String update(Voucher voucher, Long id, UserDetails userDetails) {
        Voucher voucherOrigin = voucherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_EXIST.getCode()));
        voucherOrigin.setName(voucher.getName());
        voucherOrigin.setDescription(voucher.getDescription());
        voucherOrigin.setEndDate(voucher.getEndDate());
        voucherOrigin.setStartDate(voucher.getStartDate());
        voucherOrigin.setPercentAmount(voucher.getPercentAmount());
        voucherOrigin.setMaxMoneyAmount(voucher.getMaxMoneyAmount());
        voucherRepo.save(voucherOrigin);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public List<Voucher> findAll(Long id) {
        return id == null
                ? voucherRepo.findAll()
                : Arrays.asList(voucherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_EXIST.getCode())));
    }
}
