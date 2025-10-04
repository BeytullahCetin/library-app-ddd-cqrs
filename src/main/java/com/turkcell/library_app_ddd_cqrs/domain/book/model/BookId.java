package com.turkcell.library_app_ddd_cqrs.domain.book.model;

import java.util.Objects;
import java.util.UUID;

public record BookId(UUID value) {
    public BookId {
        Objects.requireNonNull(value, "Value for BookId cannot be null!");
    }

    public static com.turkcell.library_app_ddd_cqrs.domain.book.model.BookId generate() {
        return new com.turkcell.library_app_ddd_cqrs.domain.book.model.BookId(UUID.randomUUID());
    }
}