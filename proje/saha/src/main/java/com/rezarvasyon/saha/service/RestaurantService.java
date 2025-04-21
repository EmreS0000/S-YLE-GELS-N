package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.LoginRestaurantDto;
import com.rezarvasyon.saha.dto.OrderItemDto;
import com.rezarvasyon.saha.dto.RegisterRestaurantDto;
import com.rezarvasyon.saha.entity.Menu;
import com.rezarvasyon.saha.entity.OrderItems;
import com.rezarvasyon.saha.entity.Restaurant;
import com.rezarvasyon.saha.repository.MenuRepository;
import com.rezarvasyon.saha.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final MenuRepository menuRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.menuRepository = menuRepository;
    }

    public Restaurant registerRestaurant(RegisterRestaurantDto registerRestaurantDto){
        Restaurant restaurant=new Restaurant();
        restaurant.setUserName(registerRestaurantDto.getUsername());
        restaurant.setPassword(passwordEncoder.encode(registerRestaurantDto.getPassword()));
        restaurant.setEmail(registerRestaurantDto.getEmail());
        Restaurant savedRestaurant=restaurantRepository.save(restaurant);
        return restaurant;
    }
    public Restaurant loginRestaurant(LoginRestaurantDto loginRestaurantDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRestaurantDto.getEmail(),
                        loginRestaurantDto.getPassword()
                )
        );
        return restaurantRepository.findByEmail(loginRestaurantDto.getEmail())
                .orElseThrow();
    }
    public void addOrderItem(OrderItemDto orderItemDto) {

        Menu menu = menuRepository.findById(orderItemDto.getId()).orElseThrow(() -> new RuntimeException("Menu bulunamadı"));
        OrderItems orderItem = new OrderItems();
        orderItem.setName(orderItemDto.getName());
        orderItem.setPrice(orderItemDto.getPrice());

        menu.getOrderItemsList().add(orderItem);


        menuRepository.save(menu);
    }

}
