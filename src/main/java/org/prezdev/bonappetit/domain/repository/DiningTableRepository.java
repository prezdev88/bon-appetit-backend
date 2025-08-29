package org.prezdev.bonappetit.domain.repository;

import org.prezdev.bonappetit.domain.model.dining.DiningTable;

import java.util.List;
import java.util.Optional;

public interface DiningTableRepository {
    Optional<DiningTable> findById(Long id);
    
    Optional<DiningTable> findByNumber(Integer number);
    
    DiningTable save(DiningTable table);
    
    List<DiningTable> findAll();
}
