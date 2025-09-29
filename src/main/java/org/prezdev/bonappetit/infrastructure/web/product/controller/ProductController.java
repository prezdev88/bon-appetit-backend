package org.prezdev.bonappetit.infrastructure.web.product.controller;

import java.math.BigDecimal;

import org.prezdev.bonappetit.application.product.command.AddProductCommand;
import org.prezdev.bonappetit.application.product.usecase.AddProductUseCase;
import org.prezdev.bonappetit.infrastructure.web.product.request.AddProductRequest;
import org.prezdev.bonappetit.infrastructure.web.product.response.AddProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final AddProductUseCase addProduct;

    // curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{"name": "Pizza", "price": 9.99, "enabled": true}'
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddProductResponse add(@Valid @RequestBody AddProductRequest req) {
        long id = addProduct.execute(new AddProductCommand(
            req.name(),
            BigDecimal.valueOf(req.price()),
            req.enabled()
        ));
        
        return new AddProductResponse(id);
    }
}
