package com.example.happy_fitness.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestBodyDto {
    private Long trainTimeId;
    private Long facilityId;
    private Long packageId;
    private Long ptId;
    private List<Integer> dayOfWeeks;
}
