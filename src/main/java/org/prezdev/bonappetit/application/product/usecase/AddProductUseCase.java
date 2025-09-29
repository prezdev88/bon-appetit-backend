package org.prezdev.bonappetit.application.product.usecase;

import org.prezdev.bonappetit.application.product.command.AddProductCommand;

public interface AddProductUseCase {
    long execute(AddProductCommand cmd);
}
