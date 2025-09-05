package org.prezdev.bonappetit.infrastructure.persistence.jpa.springdata;

import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.dining.DiningTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataDiningTableRepository extends JpaRepository<DiningTableEntity, Long> {
    Optional<DiningTableEntity> findByNumber(Integer number);
}
