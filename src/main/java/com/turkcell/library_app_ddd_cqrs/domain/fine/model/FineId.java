package com.turkcell.library_app_ddd_cqrs.domain.fine.model;

import java.util.Objects;
import java.util.UUID;

public record FineId(UUID value) {
    public FineId {
        Objects.requireNonNull(value, "Value for FineId cannot be null!");
    }

    public static com.turkcell.library_app_ddd_cqrs.domain.fine.model.FineId generate() {
        return new com.turkcell.library_app_ddd_cqrs.domain.fine.model.FineId(UUID.randomUUID());
    }
}
