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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public void registerRestaurant(RegisterRestaurantDto registerRestaurantDto){
        Restaurant restaurant=new Restaurant();
        restaurant.setUserName(registerRestaurantDto.getUsername());
        restaurant.setPassword(registerRestaurantDto.getPassword());
        restaurant.setEmail(registerRestaurantDto.getEmail());
        Restaurant savedRestaurant=restaurantRepository.save(restaurant);
    }
    public void loginRestaurant(LoginRestaurantDto loginRestaurantDto){
        restaurantRepository.findByEmail(loginRestaurantDto.getEmail());
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
