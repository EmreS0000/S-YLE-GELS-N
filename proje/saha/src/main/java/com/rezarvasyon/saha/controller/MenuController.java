package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.entity.Menu;
import com.rezarvasyon.saha.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<?> getMenuByRestaurantId(@PathVariable Long restaurantId) {
        Optional<Menu> menu = menuService.getMenuByRestaurantId(restaurantId);
        return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.status(404).body("Menü bulunamadı");
    }
}
