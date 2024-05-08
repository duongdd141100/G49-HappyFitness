package com.example.happy_fitness.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BookingRequestBodyDto {
    private Long trainTimeId;
    private Long facilityId;
    private Long packageId;
    private Long ptId;
    private List<Integer> dayOfWeeks;
    private HashMap<Long, Long> mapDayOfWeekWithTrainTimeId;
}
