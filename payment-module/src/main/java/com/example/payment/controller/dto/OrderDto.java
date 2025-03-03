package com.example.payment.controller.dto;

import lombok.Getter;

import java.math.BigDecimal;
@Getter
public class OrderDto {
    private Long productId; // 상품명
    private String payerId; // 주문자
    private BigDecimal amount; //수량
    private String productType;
    private PaymentStatus paymentStatus;//상품 진행 상태

}
