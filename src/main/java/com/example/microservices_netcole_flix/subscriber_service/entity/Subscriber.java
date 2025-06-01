package com.example.microservices_netcole_flix.subscriber_service.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    private Long subscriberId;

    @NotBlank(message = "Le nom de famille est obligatoire")
    @Column(name = "last_name", length = 50)
    private String lastName;

    @NotBlank(message = "Le prénom est obligatoire")
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Email(message = "Format email invalide")
    @NotBlank(message = "L'email est obligatoire")
    @Column(name = "email", length = 50, unique = true)
    private String email;

    @NotNull(message = "La date d'inscription est obligatoire")
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;

    // Constructeurs
    public Subscriber() {}

    public Subscriber(String lastName, String firstName, String email, LocalDate registrationDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    // Getters et Setters
    public Long getSubscriberId() { return subscriberId; }
    public void setSubscriberId(Long subscriberId) { this.subscriberId = subscriberId; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }
    
}
