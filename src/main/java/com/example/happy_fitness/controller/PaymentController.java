package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.config.VNPayConfig;
import com.example.happy_fitness.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/create")
    public ResponseEntity<BaseResponse<String>> createPayment(@RequestParam Long amount,
                                                              @RequestParam(required = false) Long orderId,
                                                              @RequestParam(required = false) Long ticketId,
                                                              HttpServletRequest req) throws UnsupportedEncodingException {
        Map<String, String> baseParams = VNPayConfig.getBaseParams(req);
        baseParams.put("vnp_Amount", String.valueOf(amount * 100));

        baseParams.put("vnp_ReturnUrl", orderId != null
                ? VNPayConfig.vnp_ReturnUrlOrder + orderId
                : VNPayConfig.vnp_ReturnUrlCustomerTicket + ticketId);
        return ResponseEntity.ok(BaseResponse.ok(VNPayConfig.getPaymentUrl(baseParams)));
    }

    @GetMapping("/info")
    public ResponseEntity<BaseResponse<String>> paymentInfo(
            @RequestParam String responseCode,
            @RequestParam Long orderId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(paymentService.updateInfo(responseCode, orderId)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/ticket-info")
    public ResponseEntity<BaseResponse<String>> paymentTicketInfo(
            @RequestParam String responseCode,
            @RequestParam Long ticketId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(paymentService.updateTicketInfo(responseCode, ticketId)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
