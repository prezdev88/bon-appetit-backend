package org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OrderProductIdEntity implements Serializable {
    private Long orderId;
    private Long productId;
}
