package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.prezdev.bonappetit.domain.model.OrderStatus;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order.OrderStatusEntity;

@Mapper(
    componentModel = "spring",
    uses = {
        AppUserJpaMapper.class
    }
)
public interface OrderStatusJpaMapper {

    @Mapping(target = "order", ignore = true)
    @Mapping(target = "changedBy", source = "changedBy")
    OrderStatus toDomain(OrderStatusEntity entity);

    @Mapping(target = "order", ignore = true)
    @Mapping(target = "changedBy", source = "changedBy")
    OrderStatusEntity toEntity(OrderStatus domain);
}
