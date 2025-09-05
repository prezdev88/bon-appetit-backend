package org.prezdev.bonappetit.domain.repository;

import java.util.List;
import java.util.Optional;

import org.prezdev.bonappetit.domain.model.DiningTable;

public interface DiningTableRepository {
    Optional<DiningTable> findById(Long id);
    
    Optional<DiningTable> findByNumber(Integer number);
    
    DiningTable save(DiningTable table);
    
    List<DiningTable> findAll();
}
