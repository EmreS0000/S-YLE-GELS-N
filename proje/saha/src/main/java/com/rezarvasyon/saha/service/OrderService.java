package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.entity.Order;
import com.rezarvasyon.saha.entity.OrderItems;
import com.rezarvasyon.saha.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void addItemToOrder(Long orderId, OrderItems orderItem) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.getOrdersList().add(orderItem);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found!");
        }
    }
    public void removeItemFromOrder(Long orderId, Long orderItemId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            OrderItems itemToRemove = order.getOrdersList().stream()
                    .filter(item -> item.getId().equals(orderItemId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("OrderItem not found!"));
            order.getOrdersList().remove(itemToRemove);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found!");
        }
    }



    public Optional<Order> getOrderById(Long orderId) {

        return orderRepository.findById(orderId);
    }
}
