package com.example.microservices_netcole_flix.subscriber_service.repository;
import com.example.microservices_netcole_flix.subscriber_service.entity.Movie;
import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
        List<Movie> findByCategoryIdCategory(Long categoryId);
        List<Movie> findByDirectorIdDirector(Long directorId);
    
    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> findByTitleContaining(String title);
    
    List<Movie> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT m FROM Movie m WHERE YEAR(m.releaseDate) = :year")
    List<Movie> findByReleaseYear(Integer year);
}
