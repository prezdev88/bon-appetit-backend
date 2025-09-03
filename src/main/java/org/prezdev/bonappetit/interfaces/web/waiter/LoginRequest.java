package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank(message = "userIdNumber is required") String userIdNumber
) {}
