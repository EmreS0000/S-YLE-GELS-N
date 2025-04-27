package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.dto.OrderRequest;
import com.rezarvasyon.saha.entity.Order;
import com.rezarvasyon.saha.entity.OrderItems;
import com.rezarvasyon.saha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }



    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest order) {
        try {
            orderService.placeOrder(order);
            return ResponseEntity.ok("Order created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating order: " + e.getMessage());
        }
    }
    @DeleteMapping("/removeItem/{orderId}/{orderItemId}")
    public ResponseEntity<String> removeItemFromOrder(@PathVariable Long orderId, @PathVariable Long orderItemId) {
        try {
            orderService.removeItemFromOrder(orderId, orderItemId);
            return ResponseEntity.ok("Item removed from order successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error removing item from order: " + e.getMessage());
        }
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        Optional<Order> order = orderService.getOrderById(orderId);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.status(404).body("Order not found!");
        }
    }
}
