package org.prezdev.bonappetit.application.product.service;

import org.prezdev.bonappetit.application.product.command.AddProductCommand;
import org.prezdev.bonappetit.application.product.usecase.AddProductUseCase;
import org.prezdev.bonappetit.domain.model.Product;
import org.prezdev.bonappetit.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddProductService implements AddProductUseCase {

    private final ProductRepository repo;

    @Override
    public long execute(AddProductCommand cmd) {
        if (repo.existsByName(cmd.name())) {
            throw new IllegalArgumentException("Product with name " + cmd.name() + " already exists");
        }

        Product product = repo.save(Product.builder()
            .name(cmd.name())
            .price(cmd.price())
            .enabled(cmd.enabled())
            .build());

        return product.getId();
    }

}
