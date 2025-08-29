package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.domain.model.identity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAppRoleRepository extends JpaRepository<AppRole, Long> {
    Optional<AppRole> findByName(String name);
    
    boolean existsByName(String name);
}
