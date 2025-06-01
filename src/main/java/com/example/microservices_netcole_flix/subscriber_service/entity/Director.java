package com.example.microservices_netcole_flix.subscriber_service.entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "director")

public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director")
    private Long idDirector;

    @NotBlank(message = "Le nom du réalisateur est obligatoire")
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movie> movies;

    // Constructeurs
    public Director() {}

    public Director(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    // Getters et Setters
    public Long getIdDirector() { return idDirector; }
    public void setIdDirector(Long idDirector) { this.idDirector = idDirector; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public List<Movie> getMovies() { return movies; }
    public void setMovies(List<Movie> movies) { this.movies = movies; }
}
