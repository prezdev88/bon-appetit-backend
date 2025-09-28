package org.prezdev.bonappetit.infrastructure.web.waiter.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank(message = "userIdNumber is required") String userIdNumber
) {}
