package com.rezarvasyon.saha.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderRequest {
    private UserRequest userRequest;
    private RestoranRequest restoranRequest;
    private List<OrderItemRequest> order;
}