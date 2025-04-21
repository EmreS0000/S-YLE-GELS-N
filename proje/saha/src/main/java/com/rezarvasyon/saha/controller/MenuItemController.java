package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.dto.MenuItemRequest;
import com.rezarvasyon.saha.entity.MenuItem;
import com.rezarvasyon.saha.entity.Restoran;
import com.rezarvasyon.saha.service.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItemRequest request) {
        MenuItem menuItem = menuItemService.createMenuItem(request);
        return new ResponseEntity<>(menuItem, HttpStatus.CREATED);
    }

    @GetMapping("/restoran")
    public ResponseEntity<List<MenuItem>> getMenuItemsByRestoran(@PathVariable Restoran restoran) {
        List<MenuItem> items = menuItemService.getMenuItemsByRestoran(restoran);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}