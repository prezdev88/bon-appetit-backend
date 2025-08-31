package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataAppUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppUserRepositoryAdapter implements AppUserRepository {

    private final SpringDataAppUserRepository repo;

    @Override
    public Optional<AppUser> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public AppUser save(AppUser user) {
        return repo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<AppUser> findAll() {
        return repo.findAll();
    }

    @Override
    public List<AppUser> findAllByRoleName(String roleName) {
        return repo.findAllByRoles_Name(roleName);
    }
}
