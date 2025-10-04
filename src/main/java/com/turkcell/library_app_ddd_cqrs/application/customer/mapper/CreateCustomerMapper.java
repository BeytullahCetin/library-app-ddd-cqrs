package com.turkcell.library_app_ddd_cqrs.application.customer.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.customer.command.CreateCustomerCommand;
import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CreatedCustomerResponse;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;

@Component
public class CreateCustomerMapper {

	public Customer toDomain(CreateCustomerCommand command) {
		return Customer.create(command.name(), command.email(), command.phone(), command.registerDate());
	}

	public CreatedCustomerResponse toResponse(Customer domain) {
		return new CreatedCustomerResponse(
				domain.getId().value(),
				domain.getName(),
				domain.getEmail(),
				domain.getPhone(),
				domain.getRegisterDate());
	}

}
