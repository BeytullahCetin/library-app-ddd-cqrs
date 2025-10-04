package com.turkcell.library_app_ddd_cqrs.application.borrow.query;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.BorrowResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotNull;

public record FindByIdBorrowQuery(
		@NotNull UUID id)
		implements Query<BorrowResponse> {

}

