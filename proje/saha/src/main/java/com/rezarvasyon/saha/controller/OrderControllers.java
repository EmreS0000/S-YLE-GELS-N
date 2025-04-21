package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.dto.OrderRequest;
import com.rezarvasyon.saha.entity.Order;
import com.rezarvasyon.saha.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) {
        Order newOrder = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
}