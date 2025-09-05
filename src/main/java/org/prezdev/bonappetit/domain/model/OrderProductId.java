package org.prezdev.bonappetit.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderProductId {
    private Long orderId;
    private Long productId;
}
