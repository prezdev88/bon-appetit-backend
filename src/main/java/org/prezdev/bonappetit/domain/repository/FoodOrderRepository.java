package org.prezdev.bonappetit.domain.repository;

import org.prezdev.bonappetit.domain.model.order.FoodOrder;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface FoodOrderRepository {
    Optional<FoodOrder> findById(Long id);
    
    FoodOrder save(FoodOrder order);
    
    void deleteById(Long id);
   
    List<FoodOrder> findOrdersCreatedBetween(OffsetDateTime from, OffsetDateTime to);
}
