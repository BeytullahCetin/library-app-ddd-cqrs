package com.turkcell.library_app_ddd_cqrs.persistence.language;


import com.turkcell.library_app_ddd_cqrs.domain.language.model.Language;
import com.turkcell.library_app_ddd_cqrs.domain.language.model.LanguageId;
import com.turkcell.library_app_ddd_cqrs.domain.language.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LanguageRepositoryAdapter implements LanguageRepository {
    private final SpringDataLanguageRepository repository;
    private final LanguageEntityMapper languageEntityMapper;

    @Override
    public Optional<Language> findById(LanguageId id) {
        return repository
                .findById(id.value())
                .map(languageEntityMapper::toDomain);
    }

    @Override
    public List<Language> findAll() {
        return repository
                .findAll()
                .stream()
                .map(languageEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Language> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(languageEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Language save(Language language) {
        JpaLanguageEntity entity = languageEntityMapper.toEntity(language);
        entity = repository.save(entity);
        return languageEntityMapper.toDomain(entity);
    }

    @Override
    public void delete(LanguageId id) {
        repository.deleteById(id.value());
    }
}
