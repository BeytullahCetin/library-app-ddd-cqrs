package com.turkcell.library_app_ddd_cqrs.application.language.mapper;


import com.turkcell.library_app_ddd_cqrs.application.language.dto.LanguageResponse;
import com.turkcell.library_app_ddd_cqrs.domain.language.model.Language;

public class LanguageResponseMapper {
    public LanguageResponse toResponse(Language domain) {
        return new LanguageResponse(
                domain.getId().value(),
                domain.getName());
    }
}
