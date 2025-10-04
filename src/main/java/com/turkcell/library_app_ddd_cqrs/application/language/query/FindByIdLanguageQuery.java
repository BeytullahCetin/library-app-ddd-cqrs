package com.turkcell.library_app_ddd_cqrs.application.language.query;


import com.turkcell.library_app_ddd_cqrs.application.language.dto.LanguageResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record FindByIdLanguageQuery(@NotBlank UUID id) implements Query<LanguageResponse> {
}
