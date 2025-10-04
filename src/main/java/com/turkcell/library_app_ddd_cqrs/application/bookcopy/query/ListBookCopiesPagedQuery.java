package com.turkcell.library_app_ddd_cqrs.application.bookcopy.query;

import java.util.List;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.BookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.Min;

public record ListBookCopiesPagedQuery(
		@Min(0) Integer pageIndex,
		@Min(1) Integer pageSize)
		implements Query<List<BookCopyResponse>> {

}

