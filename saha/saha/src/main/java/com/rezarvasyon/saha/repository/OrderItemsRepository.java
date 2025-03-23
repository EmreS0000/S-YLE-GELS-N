package com.rezarvasyon.saha.repository;

import com.rezarvasyon.saha.entity.OrderItems;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository {
    List<OrderItems> findByOrderId(Long orderId);

}
