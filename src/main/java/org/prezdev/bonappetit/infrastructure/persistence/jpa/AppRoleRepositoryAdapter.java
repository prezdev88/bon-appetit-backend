package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.AppRole;
import org.prezdev.bonappetit.domain.repository.AppRoleRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity.AppRoleEntity;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper.AppRoleJpaMapper;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataAppRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppRoleRepositoryAdapter implements AppRoleRepository {

    private final SpringDataAppRoleRepository repo;
    private final AppRoleJpaMapper mapper;

    @Override
    public Optional<AppRole> findById(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }

    @Override
    public AppRole save(AppRole role) {
        AppRoleEntity entity = mapper.toEntity(role);
        AppRoleEntity saved = repo.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<AppRole> findAll() {
        return repo.findAll()
                   .stream()
                   .map(mapper::toDomain)
                   .toList();
    }

    @Override
    public Optional<AppRole> findByName(String name) {
        return repo.findByName(name).map(mapper::toDomain);
    }
}
