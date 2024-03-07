package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Voucher;

import java.util.List;

public interface VoucherService extends BaseService<Voucher> {
    List<Voucher> findAll();
}
