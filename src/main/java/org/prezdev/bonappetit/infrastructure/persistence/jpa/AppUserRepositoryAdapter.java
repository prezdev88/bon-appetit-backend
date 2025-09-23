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

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppUserRepositoryAdapter implements AppUserRepository {

    private final SpringDataAppUserRepository repo;
    private final AppUserJpaMapper mapper;

    @Override
    public Optional<AppUser> findById(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }

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
    public List<AppUser> findAll() {
        return repo.findAll()
                   .stream()
                   .map(mapper::toDomain)
                   .toList();
    }

    @Override
    public Page<AppUser> findAllByRoleName(String roleName, int page, int size, Sort sort) {
        return repo.findAllByRoles_Name(roleName, PageRequest.of(page, size, sort))
                   .map(mapper::toDomain);
    }

    @Override
    public Optional<AppUser> findUserBy(String userIdNumber, UserRole userRole, boolean enabled) {
        return repo.findUserBy(userIdNumber, userRole.name(), enabled).map(mapper::toDomain);
    }

    @Override
    public Page<AppUser> findAllByName(String name, int page, int size, Sort sort) {
        return repo.findAllByNameContainingIgnoreCase(name, PageRequest.of(page, size, sort))
                   .map(mapper::toDomain);
    }
}
