package com.example.microservices_netcole_flix.subscriber_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.microservices_netcole_flix.subscriber_service.entity.Director;
@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
    List<Director> findByNationality(String nationality);

    @Query("SELECT d FROM Director d WHERE d.name LIKE %:name%")
    List<Director> findByNameContaining(String name);
    
}
