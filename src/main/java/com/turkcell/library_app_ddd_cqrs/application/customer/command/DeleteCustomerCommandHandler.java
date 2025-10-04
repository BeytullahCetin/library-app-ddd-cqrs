package com.turkcell.library_app_ddd_cqrs.application.customer.command;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.DeletedCustomerResponse;
import com.turkcell.library_app_ddd_cqrs.application.customer.mapper.DeleteCustomerMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;
import com.turkcell.library_app_ddd_cqrs.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteCustomerCommandHandler implements CommandHandler<DeleteCustomerCommand, DeletedCustomerResponse> {
	private final CustomerRepository customerRepository;
	private final DeleteCustomerMapper deleteCustomerMapper;

	@Override
	public DeletedCustomerResponse handle(DeleteCustomerCommand command) {
		Optional<Customer> customer = customerRepository.findById(new CustomerId(command.id()));

		if (customer == null)
			throw new IllegalArgumentException("Bu id ile bir customer bulunamadı!");

		customerRepository.delete(customer.get().getId());
		return deleteCustomerMapper.toResponse(customer.get());
	}

}
