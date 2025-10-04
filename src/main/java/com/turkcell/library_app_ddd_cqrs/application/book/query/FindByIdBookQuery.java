package com.turkcell.library_app_ddd_cqrs.application.book.query;

import com.turkcell.library_app_ddd_cqrs.application.book.dto.BookResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record FindByIdBookQuery(@NotBlank UUID id) implements Query<BookResponse> {
}
