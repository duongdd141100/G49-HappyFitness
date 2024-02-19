package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.custom_repository.DashboardCustomRepository;
import com.example.happy_fitness.dto.DashboardInfoDto;
import com.example.happy_fitness.dto.RevenueDto;
import com.example.happy_fitness.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private DashboardCustomRepository dashboardCustomRepo;

    @Override
    public List<RevenueDto> getLast12MonthRevenue() {
        return dashboardCustomRepo.getLast12MonthRevenue();
    }

    @Override
    public DashboardInfoDto getLast30DaysInfo() {
        return dashboardCustomRepo.getLast30DaysInfo();
    }
}
