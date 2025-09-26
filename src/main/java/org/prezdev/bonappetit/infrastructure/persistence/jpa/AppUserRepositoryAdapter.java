package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.AppUser;
import org.prezdev.bonappetit.domain.model.UserRole;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppUserEntity;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper.AppUserJpaMapper;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataAppUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppUserRepositoryAdapter implements AppUserRepository {

    private final AppUserJpaMapper mapper;
    private final SpringDataAppUserRepository repo;

    @Override
    public AppUser save(AppUser user) {
        AppUserEntity entity = mapper.toEntity(user);
        AppUserEntity saved = repo.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public boolean disableById(Long id, UserRole userRole) {
        return repo.findEnabledById(id, userRole.name(), true).map(user -> {
            user.setEnabled(false);
            repo.save(user);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean enableById(Long id, UserRole userRole) {
        return repo.findEnabledById(id, userRole.name(), false).map(user -> {
            user.setEnabled(true);
            repo.save(user);
            return true;
        }).orElse(false);
    }

    @Override
    public Page<AppUser> findAllByRoleName(String roleName, int page, int size, Sort sort) {
        return repo.findAllByRoles_Name(roleName, PageRequest.of(page, size, sort))
                   .map(mapper::toDomain);
    }

    @Override
    public Optional<AppUser> findEnabledUserBy(String userIdNumber, UserRole userRole) {
        return repo.findUserBy(userIdNumber, userRole.name(), true).map(mapper::toDomain);
    }

    @Override
    public Page<AppUser> findAllByName(String name, int page, int size, Sort sort) {
        return repo.findAllByNameContainingIgnoreCase(name, PageRequest.of(page, size, sort))
                   .map(mapper::toDomain);
    }
}
