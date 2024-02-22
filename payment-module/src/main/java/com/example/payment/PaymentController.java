package com.example.payment;

import com.example.payment.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    //결제 시작
    @PostMapping("/init")
    public ResponseEntity<?> paymentInit(@RequestBody OrderDto orderDto) {
        paymentService.initiatePayment(orderDto);
        return ResponseEntity.ok().build();
    }

    //결제 요청
    @PatchMapping("/progress/{paymentId}")
    public ResponseEntity<?> paymentProgress(@PathVariable("paymentId") Long paymentId) {
        paymentService.proceedPayment(paymentId);
        return ResponseEntity.ok().build();
    }

    //결제 완료
    @PatchMapping("/complete/{paymentId}")
    public ResponseEntity<?> paymentComplete(@PathVariable("paymentId") Long paymentId) {
        paymentService.completePayment(paymentId);
        return ResponseEntity.ok().build();
    }

}