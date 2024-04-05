package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Supplier;

import java.util.List;

public interface SupplierService extends BaseService<Supplier> {

    List<Supplier> findAll();
}
