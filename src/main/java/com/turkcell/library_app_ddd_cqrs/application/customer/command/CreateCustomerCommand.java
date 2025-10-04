package com.turkcell.library_app_ddd_cqrs.application.customer.command;

import java.time.LocalDate;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CreatedCustomerResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCustomerCommand(
		@NotBlank @Size(max = 255) String name,
		@NotBlank @Size(max = 255) String email,
		@NotBlank @Size(max = 255) String phone,
		@NotBlank LocalDate registerDate)
		implements Command<CreatedCustomerResponse> {

}
