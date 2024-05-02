package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Package;

import java.util.List;

public interface PackageService extends BaseService<Package> {
    List<Package> findAll();
}
