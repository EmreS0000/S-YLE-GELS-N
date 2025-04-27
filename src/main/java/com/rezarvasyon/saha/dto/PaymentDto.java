package com.rezarvasyon.saha.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentDto {

    private Long Id;
    private String paymentMethod;

    private String CardHolderName;
    private String CardNumber;
    private String expireDate;
    private String Cvv;

    private LocalDateTime paymentDate;
    private BigDecimal amount;
}
