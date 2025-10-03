package com.turkcell.library_app_ddd_cqrs.application.author.query;

import java.util.List;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.AuthorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.Min;

public record ListAuthorsPagedQuery(
		@Min(0) Integer pageIndex,
		@Min(1) Integer pageSize)
		implements Query<List<AuthorResponse>> {

}
