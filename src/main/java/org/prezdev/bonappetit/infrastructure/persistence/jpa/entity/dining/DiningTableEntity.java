package org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.dining;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order.FoodOrderEntity;

@Entity
@Table(
    name = "dining_table",
    uniqueConstraints = @UniqueConstraint(name = "uq_dining_table_number", columnNames = "number")
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DiningTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @OneToMany(mappedBy = "table")
    @Builder.Default
    private List<FoodOrderEntity> orders = new ArrayList<>();
}
