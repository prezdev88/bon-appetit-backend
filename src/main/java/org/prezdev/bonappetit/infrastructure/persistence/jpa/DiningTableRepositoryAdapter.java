package org.prezdev.bonappetit.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.domain.model.DiningTable;
import org.prezdev.bonappetit.domain.repository.DiningTableRepository;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.dining.DiningTableEntity;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper.DiningTableJpaMapper;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata.SpringDataDiningTableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DiningTableRepositoryAdapter implements DiningTableRepository {

    private final SpringDataDiningTableRepository repo;
    private final DiningTableJpaMapper mapper;

    @Override
    public Optional<DiningTable> findById(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<DiningTable> findByNumber(Integer number) {
        return repo.findByNumber(number).map(mapper::toDomain);
    }

    @Override
    public DiningTable save(DiningTable table) {
        DiningTableEntity entity = mapper.toEntity(table);
        DiningTableEntity saved = repo.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<DiningTable> findAll() {
        return repo.findAll()
                   .stream()
                   .map(mapper::toDomain)
                   .toList();
    }
}
