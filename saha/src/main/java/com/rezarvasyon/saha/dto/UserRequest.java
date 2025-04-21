package com.rezarvasyon.saha.dto;

import com.rezarvasyon.saha.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private Payment payment;

}
