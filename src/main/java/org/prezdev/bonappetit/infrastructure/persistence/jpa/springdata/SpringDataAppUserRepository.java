package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAppUserRepository extends JpaRepository<AppUser, Long> {
}
