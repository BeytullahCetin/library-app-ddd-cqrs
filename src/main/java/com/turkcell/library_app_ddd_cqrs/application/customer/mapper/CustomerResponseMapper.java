package com.turkcell.library_app_ddd_cqrs.application.customer.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CustomerResponse;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;

@Component
public class CustomerResponseMapper {
	public CustomerResponse toResponse(Customer domain) {
		return new CustomerResponse(
				domain.getId().value(),
				domain.getName(),
				domain.getEmail(),
				domain.getPhone(),
				domain.getRegisterDate());
	}
}
