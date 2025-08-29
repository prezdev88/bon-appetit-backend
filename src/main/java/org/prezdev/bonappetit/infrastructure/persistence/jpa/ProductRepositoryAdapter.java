package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.product.Product;
import org.prezdev.bonappetit.domain.repository.ProductRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final SpringDataProductRepository repo;

    @Override
    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Product> findEnabled() {
        return repo.findByEnabledTrue();
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return repo.existsByName(name);
    }
}
