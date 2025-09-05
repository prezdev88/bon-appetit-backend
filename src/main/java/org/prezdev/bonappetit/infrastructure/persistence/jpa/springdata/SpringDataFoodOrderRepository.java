package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order.FoodOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface SpringDataFoodOrderRepository extends JpaRepository<FoodOrderEntity, Long> {
    List<FoodOrderEntity> findByCreatedAtBetween(OffsetDateTime from, OffsetDateTime to);
}
