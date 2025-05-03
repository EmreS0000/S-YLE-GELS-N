package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.OrderRequest;
import com.rezarvasyon.saha.dto.OrderItemRequest;
import com.rezarvasyon.saha.entity.*;
import com.rezarvasyon.saha.repository.OrderRepository;
import com.rezarvasyon.saha.repository.RestaurantRepository;
import com.rezarvasyon.saha.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Order placeOrder(OrderRequest orderRequest) {

        User user = userRepository.findById(orderRequest.getUserRequest().getId())
               .orElseThrow(() -> new RuntimeException("User not found"));
        Restaurant restaurant = restaurantRepository.findById(orderRequest.getRestoranRequest().getId())
             .orElseThrow(() -> new RuntimeException("Restoran not found"));


        Order order = new Order();
       order.setUser(user);
       order.setRestaurant(restaurant);
        order.setOrderStatus(OrderStatus.NEW);
        order.setTotalPrice(0.0);
        order.setOrdersList(new ArrayList<>());


        double totalPrice = 0.0;
        for (OrderItemRequest itemRequest : orderRequest.getOrder()) {
            OrderItems orderItem = new OrderItems();
            orderItem.setProductName(itemRequest.getProductName());
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPrice(itemRequest.getPrice());
            orderItem.setOrder(order);

            order.getOrdersList().add(orderItem);

            totalPrice += itemRequest.getPrice() * itemRequest.getQuantity();
        }

        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
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