package org.prezdev.bonappetit.domain.model;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product {

    private Long id;

    private String name;

    private BigDecimal price;

    @Builder.Default
    private boolean enabled = true;
}
