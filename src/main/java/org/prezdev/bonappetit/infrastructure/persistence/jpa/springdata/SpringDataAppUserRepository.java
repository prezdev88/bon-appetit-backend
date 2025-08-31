package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import java.util.List;

import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findAllByRoles_Name(String roleName);
}
