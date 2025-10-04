package com.turkcell.library_app_ddd_cqrs.application.customer.query;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CustomerResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotBlank;

public record FindByIdCustomerQuery(@NotBlank UUID id)
		implements Query<CustomerResponse> {
}
