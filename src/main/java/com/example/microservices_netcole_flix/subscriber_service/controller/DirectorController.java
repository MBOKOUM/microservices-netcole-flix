package com.example.microservices_netcole_flix.subscriber_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.microservices_netcole_flix.subscriber_service.entity.Director;
import com.example.microservices_netcole_flix.subscriber_service.service.DirectorService;

public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return ResponseEntity.ok(directors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id)
            .map(director -> ResponseEntity.ok(director))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Director> createDirector(@Valid @RequestBody Director director) {
        Director createdDirector = directorService.createDirector(director);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDirector);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Long id, 
                                                @Valid @RequestBody Director directorDetails) {
        try {
            Director updatedDirector = directorService.updateDirector(id, directorDetails);
            return ResponseEntity.ok(updatedDirector);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<Director>> getDirectorsByNationality(@PathVariable String nationality) {
        List<Director> directors = directorService.getDirectorsByNationality(nationality);
        return ResponseEntity.ok(directors);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Director>> searchDirectorsByName(@RequestParam String name) {
        List<Director> directors = directorService.searchDirectorsByName(name);
        return ResponseEntity.ok(directors);
    }
}
