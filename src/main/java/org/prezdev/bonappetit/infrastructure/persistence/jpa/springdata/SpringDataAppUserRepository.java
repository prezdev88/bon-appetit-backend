package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import java.util.Optional;

import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataAppUserRepository extends JpaRepository<AppUser, Long> {
    Page<AppUser> findAllByRoles_Name(String roleName, Pageable pageable);

    @Query("""
           SELECT u
           FROM AppUser u
           JOIN u.roles r
           WHERE u.userIdNumber = :userIdNumber
             AND r.name = 'WAITER'
             AND u.enabled = true
           """)
    Optional<AppUser> findUserBy(@Param("userIdNumber") String userIdNumber);
}
