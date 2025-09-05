// DiningTableJpaMapper.java  (rompe el ciclo: no depende de FoodOrderJpaMapper)
package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.prezdev.bonappetit.domain.model.DiningTable;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.dining.DiningTableEntity;

@Mapper(componentModel = "spring")
public interface DiningTableJpaMapper {

    @Mapping(target = "orders", ignore = true)
    DiningTable toDomain(DiningTableEntity entity);

    @Mapping(target = "orders", ignore = true)
    DiningTableEntity toEntity(DiningTable domain);
}
