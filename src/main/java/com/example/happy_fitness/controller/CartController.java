package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.RequestMappingConstant;
import com.example.happy_fitness.dto.CartDto;
import com.example.happy_fitness.entity.Cart;
import com.example.happy_fitness.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@Slf4j
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<List<CartDto>>> view(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(cartService.findAllByUser(userDetails.getUsername())));
        } catch (Exception e) {
            log.error(RequestMappingConstant.VIEW_CART + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<String>> add(@RequestBody Cart cart,
                                                  @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(cartService.addToCart(userDetails.getUsername(), cart)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.ADD_TO_CART + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/change-quantity")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<String>> changeQuantity(@RequestBody List<CartDto> carts) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(cartService.changeQuantity(carts)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CHANGE_QUANTITY + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BaseResponse<String>> delete(@RequestBody List<Float> cartIds) {
        try {
            cartService.delete(cartIds);
            return ResponseEntity.ok(BaseResponse.ok(HttpStatus.OK.getReasonPhrase()));
        } catch (Exception e) {
            log.error(RequestMappingConstant.CHANGE_QUANTITY + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
