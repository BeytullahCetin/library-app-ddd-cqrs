package com.turkcell.library_app_ddd_cqrs.application.translator.query;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.TranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotBlank;

public record FindByIdTranslatorQuery(@NotBlank UUID id) implements Query<TranslatorResponse> {

}
