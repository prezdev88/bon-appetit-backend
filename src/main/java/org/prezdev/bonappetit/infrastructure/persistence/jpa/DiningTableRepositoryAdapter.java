package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.dining.DiningTable;
import org.prezdev.bonappetit.domain.repository.DiningTableRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataDiningTableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DiningTableRepositoryAdapter implements DiningTableRepository {

    private final SpringDataDiningTableRepository repo;

    @Override
    public Optional<DiningTable> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<DiningTable> findByNumber(Integer number) {
        return repo.findByNumber(number);
    }

    @Override
    public DiningTable save(DiningTable table) {
        return repo.save(table);
    }

    @Override
    public List<DiningTable> findAll() {
        return repo.findAll();
    }
}
