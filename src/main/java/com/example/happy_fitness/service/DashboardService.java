package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.DashboardInfoDto;
import com.example.happy_fitness.dto.RevenueDto;

import java.util.List;

public interface DashboardService {
    List<RevenueDto> getLast12MonthRevenue();

    DashboardInfoDto getLast30DaysInfo();
}
