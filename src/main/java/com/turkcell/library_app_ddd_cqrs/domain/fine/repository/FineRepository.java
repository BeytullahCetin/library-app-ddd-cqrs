package com.turkcell.library_app_ddd_cqrs.domain.fine.repository;

import com.turkcell.library_app_ddd_cqrs.domain.fine.model.Fine;
import com.turkcell.library_app_ddd_cqrs.domain.fine.model.FineId;

import java.util.List;
import java.util.Optional;

public interface FineRepository {
    Optional<Fine> findById(FineId id);

    List<Fine> findAll();

    List<Fine> findAllPaged(Integer pageIndex, Integer pageSize);

    Fine save(Fine customer);

    void delete(FineId id);
}
