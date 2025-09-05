package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.FoodOrder;
import org.prezdev.bonappetit.domain.repository.FoodOrderRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order.FoodOrderEntity;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper.FoodOrderJpaMapper;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataFoodOrderRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FoodOrderRepositoryAdapter implements FoodOrderRepository {

    private final SpringDataFoodOrderRepository repo;
    private final FoodOrderJpaMapper mapper;

    @Override
    public Optional<FoodOrder> findById(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }

    @Override
    public FoodOrder save(FoodOrder order) {
        FoodOrderEntity entity = mapper.toEntity(order);
        FoodOrderEntity saved = repo.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<FoodOrder> findOrdersCreatedBetween(OffsetDateTime from, OffsetDateTime to) {
        return repo.findByCreatedAtBetween(from, to)
                   .stream()
                   .map(mapper::toDomain)
                   .toList();
    }
}
