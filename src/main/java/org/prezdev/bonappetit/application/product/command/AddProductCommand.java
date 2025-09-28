package org.prezdev.bonappetit.application.product.command;

import java.math.BigDecimal;

public record AddProductCommand(
    String name,
    BigDecimal price,
    boolean enabled
) {}
