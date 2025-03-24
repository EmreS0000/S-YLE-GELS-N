package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.entity.OrderItems;
import com.rezarvasyon.saha.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public OrderItems createOrderItem(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }


    public Optional<OrderItems> getOrderItemById(Long id) {
        return orderItemsRepository.findById(id);
    }

    public List<OrderItems> getAllOrderItems() {
        return orderItemsRepository.findAll();
    }


    public List<OrderItems> getOrderItemsByMenuId(Long menuId) {
        return orderItemsRepository.findByMenu_Id(menuId);
    }

    public void deleteOrderItem(Long id) {
        orderItemsRepository.deleteById(id);
    }



}
