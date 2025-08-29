package org.prezdev.bonappetit.application.waiter;

import jakarta.validation.constraints.NotBlank;

public record AddWaiterCommand(
    @NotBlank(message = "name is required") String name
) {}
