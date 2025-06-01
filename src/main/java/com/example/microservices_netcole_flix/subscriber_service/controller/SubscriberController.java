package com.example.microservices_netcole_flix.subscriber_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.microservices_netcole_flix.subscriber_service.service.SubscriberService;
import com.example.microservices_netcole_flix.subscriber_service.entity.Subscriber;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

public class SubscriberController {
        @Autowired
    private SubscriberService subscriberService;

    @GetMapping
    public ResponseEntity<List<Subscriber>> getAllSubscribers() {
        List<Subscriber> subscribers = subscriberService.getAllSubscribers();
        return ResponseEntity.ok(subscribers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscriber> getSubscriberById(@PathVariable Long id) {
        return subscriberService.getSubscriberById(id)
            .map(subscriber -> ResponseEntity.ok(subscriber))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Subscriber> getSubscriberByEmail(@PathVariable String email) {
        return subscriberService.getSubscriberByEmail(email)
            .map(subscriber -> ResponseEntity.ok(subscriber))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Subscriber> createSubscriber(@Valid @RequestBody Subscriber subscriber) {
        try {
            Subscriber createdSubscriber = subscriberService.createSubscriber(subscriber);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscriber);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscriber> updateSubscriber(@PathVariable Long id, 
                                                    @Valid @RequestBody Subscriber subscriberDetails) {
        try {
            Subscriber updatedSubscriber = subscriberService.updateSubscriber(id, subscriberDetails);
            return ResponseEntity.ok(updatedSubscriber);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable Long id) {
        subscriberService.deleteSubscriber(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Subscriber>> searchByLastName(@RequestParam String lastName) {
        List<Subscriber> subscribers = subscriberService.searchByLastName(lastName);
        return ResponseEntity.ok(subscribers);
    }
}
