package org.prezdev.bonappetit.domain.model;

import lombok.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderStatus {

    private Long id;

    private FoodOrder order;

    private OrderStatusType status;

    private OffsetDateTime changedAt;

    private AppUser changedBy;
}
