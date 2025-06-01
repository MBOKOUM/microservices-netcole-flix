package com.example.microservices_netcole_flix.subscriber_service.repository;
import com.example.microservices_netcole_flix.subscriber_service.entity.Subscriber;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> 
{
    Optional<Subscriber> findByEmail(String email);

    @Query("SELECT s FROM Subscriber s WHERE s.lastName LIKE %:lastName%")
    List<Subscriber> finByLastNameContaining(String lastName);
    boolean existsByEmail(String email);
}
