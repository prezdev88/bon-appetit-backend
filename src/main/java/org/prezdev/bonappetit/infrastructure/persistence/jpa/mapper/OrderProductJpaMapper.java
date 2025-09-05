package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.prezdev.bonappetit.domain.model.OrderProduct;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.order.OrderProductEntity;

@Mapper(
    componentModel = "spring",
    uses = {
        OrderProductIdJpaMapper.class,
        ProductJpaMapper.class,
        AppUserJpaMapper.class
    }
)
public interface OrderProductJpaMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", source = "product")
    @Mapping(target = "createdBy", source = "createdBy")
    OrderProduct toDomain(OrderProductEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", source = "product")
    @Mapping(target = "createdBy", source = "createdBy")
    OrderProductEntity toEntity(OrderProduct domain);
}
