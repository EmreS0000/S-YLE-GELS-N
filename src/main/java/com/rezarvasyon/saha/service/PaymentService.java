package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.PaymentDto;
import com.rezarvasyon.saha.entity.Order;
import com.rezarvasyon.saha.entity.Payment;
import com.rezarvasyon.saha.repository.OrderRepository;
import com.rezarvasyon.saha.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public Payment createPayment(PaymentDto paymentDto){
      //  Order order=orderRepository.findById(paymentDto.getId())
         //       .orElseThrow();
                Payment payment=new Payment();
                payment.setPaymentMethod(paymentDto.getPaymentMethod());
                payment.setAmount(paymentDto.getAmount());
                payment.setPaymentDate(paymentDto.getPaymentDate());

                if("CARD".equalsIgnoreCase(paymentDto.getPaymentMethod())){
                    payment.setCardHolderName(paymentDto.getCardHolderName());
                    payment.setCvv(paymentDto.getCvv());
                    payment.setCardNumber(paymentDto.getCardNumber());
                    payment.setExpireDate(paymentDto.getExpireDate());

                }
                return paymentRepository.save(payment);


        }
}
