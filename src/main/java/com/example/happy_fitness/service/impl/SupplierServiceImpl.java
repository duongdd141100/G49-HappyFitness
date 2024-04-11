package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Supplier;
import com.example.happy_fitness.repository.SupplierRepository;
import com.example.happy_fitness.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepo;

    @Override
    public String create(UserDetails userDetails, Supplier supplier) {
        return null;
    }

    @Override
    public String update(Supplier supplier, Long id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }
}
