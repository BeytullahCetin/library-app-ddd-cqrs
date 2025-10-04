package com.turkcell.library_app_ddd_cqrs.interfaces.web;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app_ddd_cqrs.application.customer.command.CreateCustomerCommand;
import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CreatedCustomerResponse;
import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CustomerResponse;
import com.turkcell.library_app_ddd_cqrs.application.customer.query.FindByIdCustomerQuery;
import com.turkcell.library_app_ddd_cqrs.application.customer.query.ListCustomerPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class CustomerController {
	private final QueryHandler<ListCustomerPagedQuery, List<CustomerResponse>> listCustomerQueryHandler;
	private final QueryHandler<FindByIdCustomerQuery, CustomerResponse> findByIdCustomerQueryHandler;
	private final CommandHandler<CreateCustomerCommand, CreatedCustomerResponse> createCustomerCommandHandler;

	@GetMapping("/v1/customers")
	public List<CustomerResponse> getCustomersPaged(@Valid ListCustomerPagedQuery query) {
		return listCustomerQueryHandler.handle(query);
	}

	@GetMapping("/v1/customers/{id}")
	public CustomerResponse getCustomersPaged(@Valid FindByIdCustomerQuery query) {
		return findByIdCustomerQueryHandler.handle(query);
	}

	@PostMapping
	public CreatedCustomerResponse createCustomer(@RequestBody CreateCustomerCommand command) {
		return createCustomerCommandHandler.handle(command);
	}
}
