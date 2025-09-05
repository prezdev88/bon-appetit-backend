package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAppRoleRepository extends JpaRepository<AppRoleEntity, Long> {
    Optional<AppRoleEntity> findByName(String name);
    
    boolean existsByName(String name);
}
