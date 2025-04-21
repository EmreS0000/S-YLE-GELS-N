package com.rezarvasyon.saha.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemRequest {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Long RestoranId;
}