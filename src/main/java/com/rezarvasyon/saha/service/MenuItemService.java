package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.MenuItemRequest;
import com.rezarvasyon.saha.entity.MenuItem;
import com.rezarvasyon.saha.entity.Restaurant;
import com.rezarvasyon.saha.repository.MenuItemRepository;
import com.rezarvasyon.saha.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public MenuItem createMenuItem(MenuItemRequest request){
        Restaurant restaurant =restaurantRepository.findById(request.getRestoranId())
                .orElseThrow(()->new RuntimeException("Restoran bulunamadi"));
        MenuItem menuItem=new MenuItem();
        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());

        menuItem.setRestaurant(restaurant);
        return menuItemRepository.save(menuItem);
    }
    public Optional<MenuItem> getMenuItemsByRestaurant(Restaurant restaurant) {
        return menuItemRepository.findByRestaurant(restaurant);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}