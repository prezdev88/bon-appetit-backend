package org.prezdev.bonappetit.application.waiter.dto;

import java.util.List;

public record PageModel<T>(
    List<T> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean last
) {}