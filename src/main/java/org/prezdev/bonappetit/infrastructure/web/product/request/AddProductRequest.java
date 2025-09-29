package org.prezdev.bonappetit.infrastructure.web.product.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AddProductRequest(
    @NotBlank(message = "name cannot be blank") String name,
    @Positive(message = "price must be greater than zero") double price,
    boolean enabled
) {}
