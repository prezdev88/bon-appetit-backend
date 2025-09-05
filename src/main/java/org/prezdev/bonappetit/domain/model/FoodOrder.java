package org.prezdev.bonappetit.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FoodOrder {

    private Long id;

    private DiningTable table;

    private AppUser createdBy;

    @Builder.Default
    private BigDecimal total = BigDecimal.ZERO;

    private OffsetDateTime createdAt;

    @Builder.Default
    private List<OrderStatus> statuses = new ArrayList<>();

    @Builder.Default
    private List<OrderProduct> items = new ArrayList<>();
}
