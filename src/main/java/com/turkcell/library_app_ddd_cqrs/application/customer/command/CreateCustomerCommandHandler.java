package com.turkcell.library_app_ddd_cqrs.application.customer.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CreatedCustomerResponse;
import com.turkcell.library_app_ddd_cqrs.application.customer.mapper.CreateCustomerMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;
import com.turkcell.library_app_ddd_cqrs.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, CreatedCustomerResponse> {

	private final CustomerRepository customerRepository;
	private final CreateCustomerMapper createCustomerMapper;

	@Override
	public CreatedCustomerResponse handle(CreateCustomerCommand command) {
		Customer customer = createCustomerMapper.toDomain(command);
		customer = customerRepository.save(customer);
		return createCustomerMapper.toResponse(customer);
	}

}
