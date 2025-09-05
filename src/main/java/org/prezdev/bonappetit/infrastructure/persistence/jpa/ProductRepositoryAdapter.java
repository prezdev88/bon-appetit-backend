package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.Product;
import org.prezdev.bonappetit.domain.repository.ProductRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.product.ProductEntity;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper.ProductJpaMapper;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final SpringDataProductRepository repo;
    private final ProductJpaMapper mapper;

    @Override
    public Optional<Product> findById(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return repo.findByName(name).map(mapper::toDomain);
    }

    @Override
    public List<Product> findEnabled() {
        return repo.findByEnabledTrue()
                   .stream()
                   .map(mapper::toDomain)
                   .toList();
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        ProductEntity saved = repo.save(entity);
        return mapper.toDomain(saved);
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
