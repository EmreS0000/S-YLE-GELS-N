package com.rezarvasyon.saha.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    private String productName;
    private Integer quantity;
    private Double price;

}