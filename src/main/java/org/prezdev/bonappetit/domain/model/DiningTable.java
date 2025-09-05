package org.prezdev.bonappetit.domain.model;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DiningTable {

    private Long id;
    private Integer number;

    @Builder.Default
    private List<FoodOrder> orders = new ArrayList<>();
}
