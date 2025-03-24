package com.rezarvasyon.saha.controller;

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

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            orderService.createOrder(order);
            return ResponseEntity.ok("Order created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating order: " + e.getMessage());
        }
    }


    @PostMapping("/addItem/{orderId}")
    public ResponseEntity<String> addItemToOrder(@PathVariable Long orderId, @RequestBody OrderItems orderItem) {
        try {
            orderService.addItemToOrder(orderId, orderItem);
            return ResponseEntity.ok("Item added to order successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error adding item to order: " + e.getMessage());
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
