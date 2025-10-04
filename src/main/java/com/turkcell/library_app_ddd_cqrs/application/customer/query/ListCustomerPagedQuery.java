package com.turkcell.library_app_ddd_cqrs.application.customer.query;

import java.util.List;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CustomerResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.Min;

public record ListCustomerPagedQuery(
		@Min(0) Integer pageIndex,
		@Min(1) Integer pageSize)
		implements Query<List<CustomerResponse>> {
}
