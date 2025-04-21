package com.rezarvasyon.saha.repository;

import com.rezarvasyon.saha.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {
    List<Restoran> findByNameContainingIgnoreCase(String name);
}

