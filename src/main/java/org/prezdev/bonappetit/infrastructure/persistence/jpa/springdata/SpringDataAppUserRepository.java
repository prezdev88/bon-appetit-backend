package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import java.util.Optional;

import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataAppUserRepository extends JpaRepository<AppUserEntity, Long> {

    Page<AppUserEntity> findAllByRoles_Name(String roleName, Pageable pageable);

    @Query("""
       SELECT u
       FROM AppUserEntity u
       WHERE lower(function('unaccent', u.name))
             LIKE lower(function('unaccent', concat('%', :name, '%')))
       """)
    Page<AppUserEntity> findAllByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);


    @Query("""
           SELECT u
           FROM AppUserEntity u
           JOIN u.roles r
           WHERE u.userIdNumber = :userIdNumber
             AND r.name = 'WAITER'
             AND u.enabled = true
           """)
    Optional<AppUserEntity> findUserBy(@Param("userIdNumber") String userIdNumber);
}
