package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.domain.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    boolean existsByName(String name);
    
    List<Product> findByEnabledTrue();
}
