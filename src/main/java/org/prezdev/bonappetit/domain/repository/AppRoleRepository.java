package org.prezdev.bonappetit.domain.repository;

import org.prezdev.bonappetit.domain.model.identity.AppRole;

import java.util.List;
import java.util.Optional;

public interface AppRoleRepository {
    Optional<AppRole> findById(Long id);
    
    AppRole save(AppRole role);
    
    List<AppRole> findAll();
}
