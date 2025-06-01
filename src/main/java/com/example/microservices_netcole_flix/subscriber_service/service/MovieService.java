package com.example.microservices_netcole_flix.subscriber_service.service;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

import com.example.microservices_netcole_flix.subscriber_service.entity.Director;
import com.example.microservices_netcole_flix.subscriber_service.entity.Movie;
import com.example.microservices_netcole_flix.subscriber_service.entity.Category;
import com.example.microservices_netcole_flix.subscriber_service.repository.CategoryRepository;
import com.example.microservices_netcole_flix.subscriber_service.repository.DirectorRepository;
import com.example.microservices_netcole_flix.subscriber_service.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
        private MovieRepository movieRepository;
        @Autowired
        private CategoryRepository categoryRepository;
        @Autowired
        private DirectorRepository directorRepository;

        public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
    
    public Movie createMovie(Movie movie) {
        if(movie.getCategory() != null && movie.getCategory().getIdCategory()!= null){
            Category category = categoryRepository.findById(movie.getCategory().getIdCategory())
            .orElseThrow(() -> new RuntimeException("category absente"));
            movie.setCategory(category);
        }
        if (movie.getDirector() != null && movie.getDirector().getIdDirector() != null){
            Director director = directorRepository.findById(movie.getDirector().getIdDirector())
            .orElseThrow(new RuntimeException("categorie absente"));
            movie.setDirector(director);   
        }
    return movieRepository.save(movie);
}
public Movie updateMovie(Long id, Movie movieDetails) {
        return movieRepository.findById(id)
            .map(movie -> {
                movie.setTitle(movieDetails.getTitle());
                movie.setReleaseDate(movieDetails.getReleaseDate());
                
                if (movieDetails.getCategory() != null && movieDetails.getCategory().getIdCategory() != null) {
                    Category category = categoryRepository.findById(movieDetails.getCategory().getIdCategory())
                        .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
                    movie.setCategory(category);
                }
                
                if (movieDetails.getDirector() != null && movieDetails.getDirector().getIdDirector() != null) {
                    Director director = directorRepository.findById(movieDetails.getDirector().getIdDirector())
                        .orElseThrow(() -> new RuntimeException("Réalisateur non trouvé"));
                    movie.setDirector(director);
                }
                
                return movieRepository.save(movie);
            })
            .orElseThrow(() -> new RuntimeException("Film non trouvé avec l'id : " + id));
    }
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
public List<Movie> getMoviesByCategory(Long categoryId) {
        return movieRepository.findByCategoryIdCategory(categoryId);
    }

    public List<Movie> getMoviesByDirector(Long directorId) {
        return movieRepository.findByDirectorIdDirector(directorId);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title);
    }

    public List<Movie> getMoviesByYear(Integer year) {
        return movieRepository.findByReleaseYear(year);
    }

    public List<Movie> getMoviesByDateRange(LocalDate startDate, LocalDate endDate) {
        return movieRepository.findByReleaseDateBetween(startDate, endDate);
    }
}
