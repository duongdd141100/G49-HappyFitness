package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Schedule;
import com.example.happy_fitness.entity.TrainHistory;
import com.example.happy_fitness.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@Slf4j
@CrossOrigin
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Schedule>>> findAll(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(scheduleService.findAll(userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.GET_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<String>> update(@AuthenticationPrincipal UserDetails userDetails,
                                                       @RequestBody TrainHistory trainHistory) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(scheduleService.update(trainHistory, trainHistory.getId(), userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.GET_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/attend/{scheduleId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PERSONAL_TRAINER')")
    public ResponseEntity<BaseResponse<String>> attend(@AuthenticationPrincipal UserDetails userDetails,
                                                       @PathVariable Long scheduleId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(scheduleService.attend(scheduleId, userDetails)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.ATTEND + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
