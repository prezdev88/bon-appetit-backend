package org.prezdev.bonappetit.application.waiter;

import java.util.List;

public record WaiterDto(
    Long id,
    String name,
    boolean enabled,
    List<String> roles
) {}
