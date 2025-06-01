package com.example.microservices_netcole_flix.subscriber_service.repository;

import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    Optional<Category> findByName(String name);
    boolean existsByName(String name);
    
}
