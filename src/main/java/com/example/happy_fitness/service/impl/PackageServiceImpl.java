package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Package;
import com.example.happy_fitness.repository.PackageRepository;
import com.example.happy_fitness.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    private PackageRepository packageRepo;

    @Override
    public String create(UserDetails userDetails, Package aPackage) {
        packageRepo.save(aPackage);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String update(Package aPackage, Long id, UserDetails userDetails) {
        Package originPackage = packageRepo.findById(id).get();
        originPackage.setName(aPackage.getName());
        originPackage.setType(aPackage.getType());
        originPackage.setPrice(aPackage.getPrice());
        originPackage.setTotalSlot(aPackage.getTotalSlot());
        packageRepo.save(originPackage);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public List<Package> findAll() {
        return packageRepo.findAll();
    }
}
