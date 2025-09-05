package org.prezdev.bonappetit.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderProduct {

    private OrderProductId id;

    private FoodOrder order;

    private Product product;

    private Integer quantity;

    private BigDecimal subtotal;

    private String notes;

    private AppUser createdBy;

    private OffsetDateTime createdAt;
}
