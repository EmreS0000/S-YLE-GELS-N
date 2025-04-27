package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.dto.PaymentDto;
import com.rezarvasyon.saha.entity.Payment;
import com.rezarvasyon.saha.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentDto paymentDto){
        Payment payment=paymentService.createPayment(paymentDto);
        return ResponseEntity.ok(payment);
    }
}
