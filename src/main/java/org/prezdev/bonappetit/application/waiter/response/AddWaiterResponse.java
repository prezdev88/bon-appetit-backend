package org.prezdev.bonappetit.application.waiter.response;

import java.util.List;

public record AddWaiterResponse(
    Long id,
    String name,
    boolean enabled,
    List<String> roles
) {}
