package org.prezdev.bonappetit.domain.repository;

import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository {
    Optional<AppUser> findById(Long id);
    
    AppUser save(AppUser user);
    
    void deleteById(Long id);
    
    List<AppUser> findAll();

    Page<AppUser> findAllByRoleName(String roleName, int page, int size, Sort sort);
}
