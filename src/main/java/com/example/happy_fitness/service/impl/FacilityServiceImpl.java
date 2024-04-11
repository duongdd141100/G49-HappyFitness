package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.repository.FacilityRepository;
import com.example.happy_fitness.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepo;

    @Override
    public Facility create(UserDetails userDetails, Facility facility) {
        return null;
    }

    @Override
    public String update(Facility facility, Long id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public List<Facility> findAll() {
        return facilityRepo.findAll().stream().map(x -> {
            x.setManager(null);
            return x;
        }).toList();
    }

    @Override
    public Facility findById(Long coachId) {
        return facilityRepo.findById(coachId).get();
    }
}
