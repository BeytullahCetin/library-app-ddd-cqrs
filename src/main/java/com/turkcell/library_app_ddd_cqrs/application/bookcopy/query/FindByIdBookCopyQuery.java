package com.turkcell.library_app_ddd_cqrs.application.bookcopy.query;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.BookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotNull;

public record FindByIdBookCopyQuery(
		@NotNull UUID id)
		implements Query<BookCopyResponse> {

}

