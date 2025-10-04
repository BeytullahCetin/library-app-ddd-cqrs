package com.turkcell.library_app_ddd_cqrs.application.borrow.query;

import java.util.List;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.BorrowResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotNull;

public record FindByCustomerIdBorrowQuery(
		@NotNull UUID customerId)
		implements Query<List<BorrowResponse>> {

}

