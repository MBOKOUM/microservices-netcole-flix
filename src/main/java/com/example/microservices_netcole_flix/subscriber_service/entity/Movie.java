package com.example.microservices_netcole_flix.subscriber_service.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;

    @NotBlank(message = "Le titre du film est obligatoire")
    @Column(name = "title", length = 50)
    private String title;

    @NotNull(message = "La date de sortie est obligatoire")
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_director", nullable = false)
    private Director director;

    // Constructeurs
    public Movie() {}

    public Movie(String title, LocalDate releaseDate, Category category, Director director) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.category = category;
        this.director = director;
    }

    // Getters et Setters
    public Long getIdMovie() { return idMovie; }
    public void setIdMovie(Long idMovie) { this.idMovie = idMovie; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Director getDirector() { return director; }
    public void setDirector(Director director) { this.director = director; }
    
}
