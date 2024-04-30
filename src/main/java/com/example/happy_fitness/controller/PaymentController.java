package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.config.VNPayConfig;
import com.example.happy_fitness.dto.BookingRequestBodyDto;
import com.example.happy_fitness.repository.PackageRepository;
import com.example.happy_fitness.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PackageRepository packageRepo;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String>> createPayment(@RequestParam(required = false) Long amount,
                                                              @RequestParam(required = false) Long orderId,
                                                              @RequestParam(required = false) Long ticketId,
                                                              @RequestBody(required = false) BookingRequestBodyDto bookingRequestBodyDto,
                                                              HttpServletRequest req) throws UnsupportedEncodingException {
        Map<String, String> baseParams = VNPayConfig.getBaseParams(req);
        if (orderId != null) {
            baseParams.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrlOrder + "/" + orderId);
            baseParams.put("vnp_Amount", String.valueOf(amount * 100));
        } else if (ticketId != null) {
            baseParams.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrlCustomerTicket + ticketId);
            baseParams.put("vnp_Amount", String.valueOf(amount * 100));
        } else {
            String params =String.format("?dayOfWeeks=%s" +
                    "&ptId=%s" +
                    "&packageId=%s" +
                    "&facilityId=%s" +
                    "&trainTimeId=%s",
                    String.join("", bookingRequestBodyDto.getDayOfWeeks().stream().map(Object::toString).toList()),
                    bookingRequestBodyDto.getPtId(), bookingRequestBodyDto.getPackageId(), bookingRequestBodyDto.getFacilityId(),
                    bookingRequestBodyDto.getTrainTimeId());
            baseParams.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrlOrder + params);
            String price = String.format("%f", packageRepo.findById(bookingRequestBodyDto.getPackageId()).get().getPrice() * 100);
            baseParams.put("vnp_Amount", price.substring(0, price.indexOf('.')));
        }
        return ResponseEntity.ok(BaseResponse.ok(VNPayConfig.getPaymentUrl(baseParams)));
    }

    @PostMapping("/info")
    public ResponseEntity<BaseResponse<String>> paymentInfo(
            @RequestParam String responseCode,
            @RequestParam(required = false) Long orderId,
            @RequestBody(required = false) BookingRequestBodyDto bookingRequestBodyDto) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(orderId != null
                    ? paymentService.updateOrderInfo(responseCode, orderId)
                    : paymentService.createSchedule(responseCode, bookingRequestBodyDto)));
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
