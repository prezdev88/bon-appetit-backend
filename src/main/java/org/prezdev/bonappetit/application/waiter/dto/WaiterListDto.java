package org.prezdev.bonappetit.application.waiter.dto;

public record WaiterListDto(
    Long id,
    String name,
    boolean enabled
) {}
