package com.example.microservices_netcole_flix.subscriber_service.service;
import com.example.microservices_netcole_flix.subscriber_service.entity.Subscriber;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;


import com.example.microservices_netcole_flix.subscriber_service.repository.SubscriberRepository;

public class SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;
    public List<Subscriber> getAllSubscribers(){
        return subscriberRepository.findAll();

    }
    public Optional<Subscriber> getSubscriberById(Long id) {
        return subscriberRepository.findById(id);
    }

    public Optional<Subscriber> getSubscriberByEmail(String email) {
        return subscriberRepository.findByEmail(email);
    }

    public Subscriber createSubscriber(Subscriber subscriber) {
        if (subscriberRepository.existsByEmail(subscriber.getEmail())) {
            throw new RuntimeException("Un abonné avec cet email existe déjà");
        }
        if (subscriber.getRegistrationDate() == null) {
            subscriber.setRegistrationDate(LocalDate.now());
        }
        return subscriberRepository.save(subscriber);
    }

    public Subscriber updateSubscriber(Long id, Subscriber subscriberDetails) {
        return subscriberRepository.findById(id)
            .map(subscriber -> {
                subscriber.setLastName(subscriberDetails.getLastName());
                subscriber.setFirstName(subscriberDetails.getFirstName());
                subscriber.setEmail(subscriberDetails.getEmail());
                return subscriberRepository.save(subscriber);
            })
            .orElseThrow(() -> new RuntimeException("Abonné non trouvé avec l'id : " + id));
    }

    public void deleteSubscriber(Long id) {
        subscriberRepository.deleteById(id);
    }

    public List<Subscriber> searchByLastName(String lastName) {
        return subscriberRepository.findByLastName.finByLastNameContaining(lastName);
    }
}