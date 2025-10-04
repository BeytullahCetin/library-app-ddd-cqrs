package com.turkcell.library_app_ddd_cqrs.domain.language.repository;

import com.turkcell.library_app_ddd_cqrs.domain.language.model.Language;
import com.turkcell.library_app_ddd_cqrs.domain.language.model.LanguageId;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository {
    Optional<Language> findById(LanguageId id);

    List<Language> findAll();

    List<Language> findAllPaged(Integer pageIndex, Integer pageSize);

    Language save(Language reservation);

    void delete(LanguageId id);
}
