package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.constraints.NotBlank;

public record AddWaiterRequest(
    @NotBlank(message = "name is required") String name
) {}
