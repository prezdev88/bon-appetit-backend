package org.prezdev.bonappetit.domain.repository;

import org.prezdev.bonappetit.domain.model.AppUser;
import org.prezdev.bonappetit.domain.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface AppUserRepository {
    AppUser save(AppUser user);
    
    boolean disableById(Long id, UserRole userRole);

    boolean enableById(Long id, UserRole userRole);

    Page<AppUser> findAllByRoleName(String roleName, int page, int size, Sort sort);

    Page<AppUser> findAllByName(String name, int page, int size, Sort sort);

    Optional<AppUser> findUserBy(String userIdNumber, UserRole userRole, boolean enabled);
}
