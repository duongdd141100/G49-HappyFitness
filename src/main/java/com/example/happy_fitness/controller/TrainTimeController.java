package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.TrainTime;
import com.example.happy_fitness.service.TrainTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/train-time")
@CrossOrigin
public class TrainTimeController {
    @Autowired
    private TrainTimeService trainTimeService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<TrainTime>>> findAll() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(trainTimeService.findAll()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_TRAIN_TIME + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
