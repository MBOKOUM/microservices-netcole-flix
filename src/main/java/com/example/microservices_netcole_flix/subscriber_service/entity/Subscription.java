package com.example.microservices_netcole_flix.subscriber_service.entity;
import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "subscription")
public class Subscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Long subscriptionId;

    @NotBlank(message = "Le type d'abonnement est obligatoire")
    @Column(name = "type", length = 50)
    private String type;

    @NotNull(message = "Le prix est obligatoire")
    @Positive(message = "Le prix doit être positif")
    @Column(name = "price", precision = 15, scale = 2)
    private BigDecimal price;

    @NotNull(message = "La durée est obligatoire")
    @Positive(message = "La durée doit être positive")
    @Column(name = "duration_months")
    private Integer durationMonths;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;

    // Constructeurs
    public Subscription() {}

    public Subscription(String type, BigDecimal price, Integer durationMonths) {
        this.type = type;
        this.price = price;
        this.durationMonths = durationMonths;
    }

    // Getters et Setters
    public Long getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(Long subscriptionId) { this.subscriptionId = subscriptionId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getDurationMonths() { return durationMonths; }
    public void setDurationMonths(Integer durationMonths) { this.durationMonths = durationMonths; }

    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments;
}}
