package com.turkcell.library_app_ddd_cqrs.application.customer.query;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CustomerResponse;
import com.turkcell.library_app_ddd_cqrs.application.customer.mapper.CustomerResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;
import com.turkcell.library_app_ddd_cqrs.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdCustomerQueryHandler implements QueryHandler<FindByIdCustomerQuery, CustomerResponse> {
	private final CustomerRepository customerRepository;
	private final CustomerResponseMapper customerResponseMapper;

	@Override
	public CustomerResponse handle(FindByIdCustomerQuery query) {
		return customerResponseMapper.toResponse(customerRepository.findById(new CustomerId(query.id())).get());
	}

}
