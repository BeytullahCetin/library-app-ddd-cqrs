package com.turkcell.library_app_ddd_cqrs.domain.language.model;

import java.util.Objects;
import java.util.UUID;

public record LanguageId(UUID value) {
    public LanguageId {
        Objects.requireNonNull(value, "Value for LanguageId cannot be null!");
    }

    public static com.turkcell.library_app_ddd_cqrs.domain.language.model.LanguageId generate() {
        return new com.turkcell.library_app_ddd_cqrs.domain.language.model.LanguageId(UUID.randomUUID());
    }
}
