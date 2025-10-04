package com.turkcell.library_app_ddd_cqrs.persistence.fine;

import com.turkcell.library_app_ddd_cqrs.domain.fine.model.Fine;
import com.turkcell.library_app_ddd_cqrs.domain.fine.model.FineId;
import com.turkcell.library_app_ddd_cqrs.domain.fine.repository.FineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FineRepositoryAdapter implements FineRepository {
    private final SpringDataFineRepository repository;
    private final FineEntityMapper fineEntityMapper;

    @Override
    public Optional<Fine> findById(FineId id) {
        return repository
                .findById(id.value())
                .map(fineEntityMapper::toDomain);
    }

    @Override
    public List<Fine> findAll() {
        return repository
                .findAll()
                .stream()
                .map(fineEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Fine> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(fineEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Fine save(Fine fine) {
        JpaFineEntity entity = fineEntityMapper.toEntity(fine);
        entity = repository.save(entity);
        return fineEntityMapper.toDomain(entity);
    }

    @Override
    public void delete(FineId id) {
        repository.deleteById(id.value());
    }
}
