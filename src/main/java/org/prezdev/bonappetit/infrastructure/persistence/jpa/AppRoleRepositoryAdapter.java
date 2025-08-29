package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.identity.AppRole;
import org.prezdev.bonappetit.domain.repository.AppRoleRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataAppRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppRoleRepositoryAdapter implements AppRoleRepository {

    private final SpringDataAppRoleRepository repo;

    @Override
    public Optional<AppRole> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public AppRole save(AppRole role) {
        return repo.save(role);
    }

    @Override
    public List<AppRole> findAll() {
        return repo.findAll();
    }
}
