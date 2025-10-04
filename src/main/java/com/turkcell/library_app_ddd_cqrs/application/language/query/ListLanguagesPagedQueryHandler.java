package com.turkcell.library_app_ddd_cqrs.application.language.query;

import com.turkcell.library_app_ddd_cqrs.application.language.dto.LanguageResponse;
import com.turkcell.library_app_ddd_cqrs.application.language.mapper.LanguageResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.language.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListLanguagesPagedQueryHandler implements QueryHandler<ListLanguagesPagedQuery, List<LanguageResponse>> {
    private final LanguageRepository languageRepository;
    private final LanguageResponseMapper languageResponseMapper;

    @Override
    public List<LanguageResponse> handle(ListLanguagesPagedQuery query) {
        return languageRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(languageResponseMapper::toResponse)
                .toList();
    }

}
