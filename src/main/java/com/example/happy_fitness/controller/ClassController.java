package com.example.happy_fitness.controller;


import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.Clazz;
import com.example.happy_fitness.repository.ClassRepository;
import com.example.happy_fitness.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
@Slf4j
@CrossOrigin
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Clazz>>> findAll(@AuthenticationPrincipal UserDetails userDetails,
                                                             @RequestParam(required = false) String type) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(classService.findAll(userDetails, type)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_CATEGORY + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String>> create(@AuthenticationPrincipal UserDetails userDetails,
                                                       @RequestBody Clazz clazz,
                                                       @RequestParam Long trainTimeId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(classService.createCustom(userDetails, clazz, trainTimeId)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_CATEGORY + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
