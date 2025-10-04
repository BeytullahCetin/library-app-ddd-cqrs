package com.turkcell.library_app_ddd_cqrs.application.book.query;


import com.turkcell.library_app_ddd_cqrs.application.book.dto.BookResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListBooksPagedQuery(
        @Min(0) Integer pageIndex,
        @Min(1) Integer pageSize)
        implements Query<List<BookResponse>> {
	
}
