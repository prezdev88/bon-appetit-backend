package org.prezdev.bonappetit.domain.repository;

import java.util.List;
import java.util.Optional;

import org.prezdev.bonappetit.domain.model.AppRole;

public interface AppRoleRepository {
    Optional<AppRole> findById(Long id);
    
    Optional<AppRole> findByName(String name);

    AppRole save(AppRole role);
    
    List<AppRole> findAll();
}
