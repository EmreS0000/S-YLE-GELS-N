package com.rezarvasyon.saha.repository;

import com.rezarvasyon.saha.entity.Order;
import com.rezarvasyon.saha.entity.Restaurant;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Order ,Long> {
    List<Order> findByRestaurant(Restaurant restaurant);

}
