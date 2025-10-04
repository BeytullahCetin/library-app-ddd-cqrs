package com.turkcell.library_app_ddd_cqrs.application.language.query;

import com.turkcell.library_app_ddd_cqrs.application.language.dto.LanguageResponse;
import com.turkcell.library_app_ddd_cqrs.application.language.mapper.LanguageResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.language.model.LanguageId;
import com.turkcell.library_app_ddd_cqrs.domain.language.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByIdLanguageQueryHandler implements QueryHandler<FindByIdLanguageQuery, LanguageResponse> {
    private final LanguageRepository languageRepository;
    private final LanguageResponseMapper languageResponseMapper;

    @Override
    public LanguageResponse handle(FindByIdLanguageQuery query) {
        return languageResponseMapper.toResponse(languageRepository.findById(new LanguageId(query.id())).get());
    }

}
