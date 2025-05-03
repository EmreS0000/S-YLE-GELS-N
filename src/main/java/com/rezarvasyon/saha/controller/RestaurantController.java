package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.dto.LoginRestaurantDto;
import com.rezarvasyon.saha.dto.LoginUserResponseDto;
import com.rezarvasyon.saha.dto.OrderItemDto;
import com.rezarvasyon.saha.dto.RegisterRestaurantDto;
import com.rezarvasyon.saha.entity.Restaurant;
import com.rezarvasyon.saha.service.JwtService;
import com.rezarvasyon.saha.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {


    private final RestaurantService restaurantService;
    private final JwtService jwtService;

    public RestaurantController(RestaurantService restaurantService, JwtService jwtService) {
        this.restaurantService = restaurantService;
        this.jwtService = jwtService;
    }



    @PostMapping("/register")
    public ResponseEntity<Restaurant> registerRestaurant(@RequestBody RegisterRestaurantDto registerRestaurantDto) {
        Restaurant registeredRestaurant = restaurantService.registerRestaurant(registerRestaurantDto);
        return ResponseEntity.ok(registeredRestaurant);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDto> loginRestaurant(@RequestBody LoginRestaurantDto loginRestaurantDto) {
        String jwtToken = restaurantService.loginRestaurant(loginRestaurantDto);
        LoginUserResponseDto loginUserResponseDto = new LoginUserResponseDto()
                .setToken(jwtToken)
                .setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginUserResponseDto);
    }


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
