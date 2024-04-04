package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Product;
import com.example.happy_fitness.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

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

    @GetMapping("/{code}")
    public ResponseEntity<BaseResponse<List<ProductDto>>> getProductDetail(@PathVariable String code, @RequestParam Float facilityId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.findProductDetail(facilityId, code)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.GET_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<String>> addProduct(@RequestParam("product") String productStr,
                                                           @RequestParam(name = "image", required = false) MultipartFile image,
                                                           @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.createCustom(userDetails, objectMapper.readValue(productStr, Product.class), image)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.ADD_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<Product>> updateProduct(@RequestParam("product") String productStr,
                                                               @RequestParam(name = "image", required = false) MultipartFile image,
                                                               @PathVariable Float id) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.updateCustom(objectMapper.readValue(productStr, Product.class), id, image)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.UPDATE_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<String>> deleteProduct(@PathVariable Float id) {
        try {
            productService.delete(Arrays.asList(id));
            return ResponseEntity.ok(BaseResponse.ok(HttpStatus.OK.getReasonPhrase()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.UPDATE_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/active/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse<String>> active(@PathVariable Float id) {
        try {
            productService.active(id);
            return ResponseEntity.ok(BaseResponse.ok(HttpStatus.OK.getReasonPhrase()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.UPDATE_PRODUCT + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
