package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.dto.LoginRestaurantDto;
import com.rezarvasyon.saha.dto.OrderItemDto;
import com.rezarvasyon.saha.dto.RegisterRestaurantDto;
import com.rezarvasyon.saha.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Register a new restaurant
    @PostMapping("/register")
    public ResponseEntity<String> registerRestaurant(@RequestBody RegisterRestaurantDto registerRestaurantDto) {
        try {
            restaurantService.registerRestaurant(registerRestaurantDto);
            return ResponseEntity.ok("Restaurant registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering restaurant: " + e.getMessage());
        }
    }

    // Login for an existing restaurant
    @PostMapping("/login")
    public ResponseEntity<String> loginRestaurant(@RequestBody LoginRestaurantDto loginRestaurantDto) {
        try {
            restaurantService.loginRestaurant(loginRestaurantDto);
            return ResponseEntity.ok("Login successful!");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Login failed: " + e.getMessage());
        }
    }

    // Add a new order item to a menu
    @PostMapping("/addOrderItem")
    public ResponseEntity<String> addOrderItem(@RequestBody OrderItemDto orderItemDto) {
        try {
            restaurantService.addOrderItem(orderItemDto);
            return ResponseEntity.ok("Order item added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding order item: " + e.getMessage());
        }
    }
}
