package com.rezarvasyon.saha.repository;

import com.rezarvasyon.saha.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Optional<Restaurant>findByEmail(String email);
}
