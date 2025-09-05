// FoodOrderJpaMapper.java  (mantiene la dependencia hacia DiningTableJpaMapper)
package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.prezdev.bonappetit.domain.model.FoodOrder;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order.FoodOrderEntity;

@Mapper(
    componentModel = "spring",
    uses = {
        DiningTableJpaMapper.class,
        AppUserJpaMapper.class,
        OrderStatusJpaMapper.class,
        OrderProductJpaMapper.class
    }
)
public interface FoodOrderJpaMapper {

    @Mapping(target = "table", source = "table")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "statuses", source = "statuses")
    @Mapping(target = "items", source = "items")
    FoodOrder toDomain(FoodOrderEntity entity);

    @Mapping(target = "table", source = "table")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "statuses", source = "statuses")
    @Mapping(target = "items", source = "items")
    FoodOrderEntity toEntity(FoodOrder domain);
}
