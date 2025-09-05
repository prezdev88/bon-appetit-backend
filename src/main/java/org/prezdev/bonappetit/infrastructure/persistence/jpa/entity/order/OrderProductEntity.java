package org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppUserEntity;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.product.ProductEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "order_product")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderProductEntity {

    @EmbeddedId
    private OrderProductIdEntity id;

    @MapsId("orderId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_product_order"))
    private FoodOrderEntity order;

    @MapsId("productId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_product_product"))
    private ProductEntity product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_product_user"))
    private AppUserEntity createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime createdAt;
}

