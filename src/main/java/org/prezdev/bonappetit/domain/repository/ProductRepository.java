package org.prezdev.bonappetit.domain.repository;

import java.util.List;
import java.util.Optional;

import org.prezdev.bonappetit.domain.model.Product;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    
    Optional<Product> findByName(String name);
    
    List<Product> findEnabled();
    
    Product save(Product product);
    
    void deleteById(Long id);
    
    boolean existsByName(String name);
}
