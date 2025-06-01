package com.example.microservices_netcole_flix.subscriber_service.service;

import java.util.List;
import java.util.Optional;

import com.example.microservices_netcole_flix.subscriber_service.entity.Director;
import com.example.microservices_netcole_flix.subscriber_service.repository.DirectorRepository;

public class DirectorService {
    
    private DirectorRepository directorRepository;

    public List<Director> getAllDirectors(){
        return directorRepository.findAll();
    }
    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }
    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }
    public Director updateDirector(Long id, Director directorDetails) {
        return directorRepository.findById(id)
            .map(director->{
                director.setName(directorDetails.getName());
                director.setNationality(directorDetails.getNationality());
                return directorRepository.save(director);
            })
            .orElseThrow(()-> new RuntimeException("Id du realisateur non trouver : " +id));
            }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);}
    public List<Director> getDirectorsByNationality(String nationality) {
        return directorRepository.findByNationality(nationality);
    }
    public List<Director> searchDirectorsByName(String name) {
        return directorRepository.findByNameContaining(name);
    }

    }