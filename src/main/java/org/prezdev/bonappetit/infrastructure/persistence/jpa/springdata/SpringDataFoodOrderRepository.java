package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.domain.model.order.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface SpringDataFoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findByCreatedAtBetween(OffsetDateTime from, OffsetDateTime to);
}
