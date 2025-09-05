package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.prezdev.bonappetit.domain.model.AppRole;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppRoleEntity;

@Mapper(componentModel = "spring")
public interface AppRoleJpaMapper {

    @Mapping(target = "users", ignore = true)
    AppRole toDomain(AppRoleEntity entity);

    @Mapping(target = "users", ignore = true)
    AppRoleEntity toEntity(AppRole domain);
}
