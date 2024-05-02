package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Attendance;
import com.example.happy_fitness.repository.AttendanceRepository;
import com.example.happy_fitness.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@Slf4j
@CrossOrigin
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/{scheduleId}")
    public ResponseEntity<BaseResponse<List<Attendance>>> getAttendance(@PathVariable Long scheduleId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(attendanceService.findAllByScheduleId(scheduleId)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.GET_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse<List<Attendance>>> updateAttendance(@RequestBody List<Attendance> attendances) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(attendanceService.updateAttendance(attendances)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.GET_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
