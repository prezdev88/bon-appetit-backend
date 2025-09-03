package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.constraints.NotBlank;

public record AddWaiterRequest(
    @NotBlank(message = "user id number is required") String userIdNumber,
    @NotBlank(message = "name is required") String name
) {}
