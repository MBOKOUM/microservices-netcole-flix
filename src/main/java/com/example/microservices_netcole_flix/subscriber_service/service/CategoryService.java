package com.example.microservices_netcole_flix.subscriber_service.service;
import com.example.microservices_netcole_flix.subscriber_service.entity.Category;
import com.example.microservices_netcole_flix.subscriber_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category createCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new RuntimeException("Une catégorie avec ce nom existe déjà");
        }
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        return categoryRepository.findById(id)
            .map(category ->{
                category.setName(categoryDetails.getName());
                return categoryRepository.save(category);
            })
            .orElseThrow(()-> new RuntimeException("Catégorie introuvable avec l'id :" + id))
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
