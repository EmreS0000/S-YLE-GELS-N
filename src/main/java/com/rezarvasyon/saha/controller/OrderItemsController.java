package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.entity.OrderItems;
import com.rezarvasyon.saha.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping
    public OrderItems createOrderItem(@RequestBody OrderItems orderItems) {
        return orderItemsService.createOrderItem(orderItems);
    }

    @GetMapping("/{id}")
    public Optional<OrderItems> getOrderItemById(@PathVariable Long id) {
        return orderItemsService.getOrderItemById(id);
    }

    @GetMapping
    public List<OrderItems> getAllOrderItems() {
        return orderItemsService.getAllOrderItems();
    }


    @GetMapping("/menu/{menuId}")
    public List<OrderItems> getOrderItemsByMenuId(@PathVariable Long menuId) {
        return orderItemsService.getOrderItemsByMenuId(menuId);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemsService.deleteOrderItem(id);
    }


}
