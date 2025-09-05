// AppUserJpaMapper.java  (mantiene uses hacia AppRoleJpaMapper)
package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.prezdev.bonappetit.domain.model.AppUser;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppUserEntity;

@Mapper(componentModel = "spring", uses = {AppRoleJpaMapper.class})
public interface AppUserJpaMapper {

    @Mapping(target = "roles", source = "roles")
    AppUser toDomain(AppUserEntity entity);

    @Mapping(target = "roles", source = "roles")
    AppUserEntity toEntity(AppUser domain);
}
