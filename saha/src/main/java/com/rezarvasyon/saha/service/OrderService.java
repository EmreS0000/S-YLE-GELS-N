package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.OrderRequest;
import com.rezarvasyon.saha.dto.OrderItemRequest;
import com.rezarvasyon.saha.entity.Order;
import com.rezarvasyon.saha.entity.OrderItem;
import com.rezarvasyon.saha.entity.User;
import com.rezarvasyon.saha.entity.Restoran;
import com.rezarvasyon.saha.entity.OrderStatus;
import com.rezarvasyon.saha.repository.OrderRepository;
import com.rezarvasyon.saha.repository.UserRepository;
import com.rezarvasyon.saha.repository.RestoranRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestoranRepository restoranRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, RestoranRepository restoranRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.restoranRepository = restoranRepository;
    }

    public Order placeOrder(OrderRequest orderRequest) {

        User user = userRepository.findById(orderRequest.getUserRequest().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Restoran restoran = restoranRepository.findById(orderRequest.getRestoranRequest().getId())
                .orElseThrow(() -> new RuntimeException("Restoran not found"));


        Order order = new Order();
        order.setUser(user);
        order.setRestoran(restoran);
        order.setStatus(OrderStatus.NEW);
        order.setTotalPrice(0.0);
        order.setOrderItems(new ArrayList<>());

        // Sipariş ürünleri ekleniyor
        double totalPrice = 0.0;
        for (OrderItemRequest itemRequest : orderRequest.getOrder()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductName(itemRequest.getProductName());
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPrice(itemRequest.getPrice());
            orderItem.setOrder(order);

            order.getOrderItems().add(orderItem);

            totalPrice += itemRequest.getPrice() * itemRequest.getQuantity();
        }

        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}
