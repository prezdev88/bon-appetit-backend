package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.prezdev.bonappetit.domain.model.OrderProductId;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order.OrderProductIdEntity;

@Mapper(componentModel = "spring")
public interface OrderProductIdJpaMapper {
    OrderProductId toDomain(OrderProductIdEntity entity);

    OrderProductIdEntity toEntity(OrderProductId domain);
}
