package org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.prezdev.bonappetit.domain.model.OrderStatusType;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppUserEntity;

import java.time.OffsetDateTime;

@Entity
@Table(name = "order_status")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_status_order"))
    private FoodOrderEntity order;

    @Enumerated(EnumType.STRING)
    @Column(length = 40, nullable = false)
    private OrderStatusType status;

    @CreationTimestamp
    @Column(name = "changed_at", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime changedAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by", nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_status_user"))
    private AppUserEntity changedBy;
}
