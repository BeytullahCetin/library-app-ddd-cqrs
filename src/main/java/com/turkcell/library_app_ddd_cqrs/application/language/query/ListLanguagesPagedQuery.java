package com.turkcell.library_app_ddd_cqrs.application.language.query;

import com.turkcell.library_app_ddd_cqrs.application.language.dto.LanguageResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListLanguagesPagedQuery(@Min(0) Integer pageIndex,
                                      @Min(1) Integer pageSize)
        implements Query<List<LanguageResponse>> {
}
