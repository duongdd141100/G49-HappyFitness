package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<ProductDto>>> getProduct(
            @RequestParam Float facilityId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Float categoryId,
            @RequestParam(required = false) Float supplierId,
            @RequestParam(required = false) Float minPrice,
            @RequestParam(required = false) Float maxPrice
    ) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.findProducts(facilityId, status, categoryId, supplierId, minPrice, maxPrice)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.GET_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
