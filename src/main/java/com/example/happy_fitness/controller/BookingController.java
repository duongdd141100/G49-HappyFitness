package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.Schedule;
import com.example.happy_fitness.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@Slf4j
@CrossOrigin
public class BookingController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<Schedule>> create(@AuthenticationPrincipal UserDetails userDetails,
                                                         @RequestBody Schedule schedule) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(scheduleService.create(userDetails, schedule)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.BOOKING + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<Schedule>> update(@AuthenticationPrincipal UserDetails userDetails,
                                                         @RequestBody Schedule schedule) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(scheduleService.update(schedule, schedule.getId(), userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.BOOKING + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
