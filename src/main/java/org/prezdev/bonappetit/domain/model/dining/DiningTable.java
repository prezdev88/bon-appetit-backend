package org.prezdev.bonappetit.domain.model.dining;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import org.prezdev.bonappetit.domain.model.order.FoodOrder;

@Entity
@Table(
    name = "dining_table",
    uniqueConstraints = @UniqueConstraint(name = "uq_dining_table_number", columnNames = "number")
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DiningTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @OneToMany(mappedBy = "table")
    @Builder.Default
    private List<FoodOrder> orders = new ArrayList<>();
}
