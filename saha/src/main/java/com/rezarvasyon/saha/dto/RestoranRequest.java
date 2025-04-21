package com.rezarvasyon.saha.dto;

import com.rezarvasyon.saha.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestoranRequest {
    private Long id;
    private String name;
    private String phoneNumber;
}
