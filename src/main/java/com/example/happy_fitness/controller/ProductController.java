package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Product;
import com.example.happy_fitness.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<String>> addProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.create(product)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.ADD_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<Product>> updateProduct(@RequestBody Product product, @PathVariable Float id) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.update(product, id)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.UPDATE_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<String>> deleteProduct(@PathVariable Float id) {
        try {
            productService.delete(id);
            return ResponseEntity.ok(BaseResponse.ok(HttpStatus.OK.getReasonPhrase()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.UPDATE_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
