package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.constraints.NotBlank;

public record AddWaiterRequest(
    @NotBlank(message = "pin is required") String pin,
    @NotBlank(message = "name is required") String name
) {}
