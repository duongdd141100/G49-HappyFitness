package com.example.happy_fitness.dto;

import lombok.Data;

import java.util.List;

@Data
public class FreePtRequestBodyDto {
    private Long trainTimeId;
    private Long facilityId;
    private List<Integer> dayOfWeeks;
}
