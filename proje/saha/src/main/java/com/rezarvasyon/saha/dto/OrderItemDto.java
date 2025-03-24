package com.rezarvasyon.saha.dto;

import com.rezarvasyon.saha.entity.Menu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto extends Menu {
    private String name;
    private double price;

}
