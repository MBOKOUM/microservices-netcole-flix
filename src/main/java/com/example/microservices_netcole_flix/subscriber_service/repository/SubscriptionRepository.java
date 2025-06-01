package com.example.microservices_netcole_flix.subscriber_service.repository;

import java.util.concurrent.Flow.Subscription;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
    List<Subscription> findByType(String type);
    List<Subscription> findByDurationMonths(Integer durationMonths);
    
}
