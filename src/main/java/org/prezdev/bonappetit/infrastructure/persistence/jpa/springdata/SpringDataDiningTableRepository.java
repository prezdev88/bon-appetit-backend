package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.domain.model.dining.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataDiningTableRepository extends JpaRepository<DiningTable, Long> {
    Optional<DiningTable> findByNumber(Integer number);
}
