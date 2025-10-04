package com.turkcell.library_app_ddd_cqrs.application.customer.dto;

import java.time.LocalDate;
import java.util.UUID;

public record DeletedCustomerResponse(
		UUID id,
		String name,
		String email,
		String phone,
		LocalDate registerDate) {
}
