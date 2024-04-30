package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.entity.Package;
import com.example.happy_fitness.repository.PackageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@Slf4j
@CrossOrigin
public class PackageController {
    @Autowired
    private PackageRepository packageRepo;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Package>>> findAll() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(packageRepo.findAll()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.FIND_PACKAGE + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
