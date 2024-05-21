package com.example.happy_fitness.controller;

import com.example.happy_fitness.common.BaseResponse;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.config.VNPayConfig;
import com.example.happy_fitness.dto.BookingRequestBodyDto;
import com.example.happy_fitness.entity.Clazz;
import com.example.happy_fitness.repository.ClassRepository;
import com.example.happy_fitness.repository.PackageRepository;
import com.example.happy_fitness.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClassRepository classRepo;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String>> createPayment(@RequestParam(required = false) Long amount,
                                                              @RequestParam(required = false) Long orderId,
                                                              @RequestParam(required = false) Long ticketId,
                                                              @RequestBody(required = false) BookingRequestBodyDto bookingRequestBodyDto,
                                                              @AuthenticationPrincipal UserDetails userDetails,
                                                              HttpServletRequest req) throws UnsupportedEncodingException, JsonProcessingException {
        Map<String, String> baseParams = VNPayConfig.getBaseParams(req);
        if (orderId != null) {
            baseParams.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrlOrder + "/" + orderId);
            baseParams.put("vnp_Amount", String.valueOf(amount * 100));
        } else if (ticketId != null) {
            baseParams.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrlCustomerTicket + ticketId);
            baseParams.put("vnp_Amount", String.valueOf(amount * 100));
        } else if (bookingRequestBodyDto.getClassId() == null) {
            String params = String.format("?&ptId=%s" +
                    "&packageId=%s" +
                    "&facilityId=%s" +
                    "&mapDayOfWeekWithTrainTimeId=%s",
                    bookingRequestBodyDto.getPtId(),
                    bookingRequestBodyDto.getPackageId(),
                    bookingRequestBodyDto.getFacilityId(),
                    objectMapper.writeValueAsString(bookingRequestBodyDto.getMapDayOfWeekWithTrainTimeId()));
            baseParams.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrlOrder + params);
            String price = String.format("%f", packageRepo.findById(bookingRequestBodyDto.getPackageId()).get().getPrice() * 100);
            baseParams.put("vnp_Amount", price.substring(0, price.indexOf('.')));
        } else {
            Clazz clazz = classRepo.findById(bookingRequestBodyDto.getClassId()).get();
            if (clazz.getClassStudents().stream().anyMatch(x -> x.getStudent().getUsername().equals(userDetails.getUsername()) && x.getRemainSlot() > 0)) {
                return ResponseEntity.badRequest().body(BaseResponse.fail("Bạn đã là học viên trong lớp này!"));
            }
            if (clazz.getClassStudents().stream().filter(x -> x.getRemainSlot() > 0).toList().size() >= 8) {
                return ResponseEntity.badRequest().body(BaseResponse.fail("Lớp đã đủ số lượng học viên!"));
            }
            String params = String.format("?classId=%s" +
                            "&packageId=%s",
                    bookingRequestBodyDto.getClassId(), bookingRequestBodyDto.getPackageId());
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
            @RequestBody(required = false) BookingRequestBodyDto bookingRequestBodyDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(orderId != null
                    ? paymentService.updateOrderInfo(responseCode, orderId)
                    : (bookingRequestBodyDto.getClassId() == null
                        ? paymentService.createSchedule(responseCode, bookingRequestBodyDto, userDetails)
                        : paymentService.joinClass(bookingRequestBodyDto, userDetails, responseCode))));
        } catch (Exception e) {
            e.printStackTrace();
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
