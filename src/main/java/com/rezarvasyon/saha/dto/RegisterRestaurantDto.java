package com.rezarvasyon.saha.dto;

import lombok.Data;

@Data
public class RegisterRestaurantDto {
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
}
