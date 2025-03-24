package com.rezarvasyon.saha.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterUserDto {
    private String username;
    private String email;
    private String password;

}
