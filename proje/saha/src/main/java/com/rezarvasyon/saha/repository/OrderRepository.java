package com.rezarvasyon.saha.repository;

import com.rezarvasyon.saha.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByRestaurant_Id(Long restaurantId);

}
