package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAppUserRepository extends JpaRepository<AppUser, Long> {
    Page<AppUser> findAllByRoles_Name(String roleName, Pageable pageable);
}
