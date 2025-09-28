package org.prezdev.bonappetit.application.waiter.response;

public record WaiterListDto(
    Long id,
    String name,
    boolean enabled
) {}
