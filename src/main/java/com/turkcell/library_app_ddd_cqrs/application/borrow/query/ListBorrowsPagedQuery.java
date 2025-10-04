package com.turkcell.library_app_ddd_cqrs.application.borrow.query;

import java.util.List;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.BorrowResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.Min;

public record ListBorrowsPagedQuery(
		@Min(0) Integer pageIndex,
		@Min(1) Integer pageSize)
		implements Query<List<BorrowResponse>> {

}

