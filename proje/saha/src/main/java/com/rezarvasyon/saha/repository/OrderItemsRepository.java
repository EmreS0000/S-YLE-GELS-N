package com.rezarvasyon.saha.repository;

import com.rezarvasyon.saha.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    List<OrderItems> findByMenu_Id(Long menuId);
}
