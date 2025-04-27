package com.rezarvasyon.saha.repository;

import com.rezarvasyon.saha.entity.MenuItem;
import com.rezarvasyon.saha.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long>
{
    Optional<MenuItem> findByRestaurant(Restaurant restaurant);
}
