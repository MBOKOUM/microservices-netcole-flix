package com.example.microservices_netcole_flix.subscriber_service.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.microservices_netcole_flix.subscriber_service.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    List<Payment> findBySubscriberId(Long subscriberId);
    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT p FROM Payment p WHERE p.subscriber.subscriberId = :subscriberId ORDER BY p.paymentDate DESC")
    List<Payment> findBySubscriberIdOrderByPaymentDateDesc(Long subscriberId);
    
}
