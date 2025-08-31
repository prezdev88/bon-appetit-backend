package org.prezdev.bonappetit.domain.repository;

import org.prezdev.bonappetit.domain.model.identity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository {
    Optional<AppUser> findById(Long id);
    
    AppUser save(AppUser user);
    
    void deleteById(Long id);
    
    List<AppUser> findAll();

    List<AppUser> findAllByRoleName(String roleName);
}
