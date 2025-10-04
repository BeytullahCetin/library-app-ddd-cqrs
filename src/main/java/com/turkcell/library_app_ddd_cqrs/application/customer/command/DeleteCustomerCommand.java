package com.turkcell.library_app_ddd_cqrs.application.customer.command;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.DeletedCustomerResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotBlank;

public record DeleteCustomerCommand(@NotBlank UUID id)
		implements Command<DeletedCustomerResponse> {
}
