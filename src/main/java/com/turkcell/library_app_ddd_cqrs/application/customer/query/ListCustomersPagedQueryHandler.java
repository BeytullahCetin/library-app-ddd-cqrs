package com.turkcell.library_app_ddd_cqrs.application.customer.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.CustomerResponse;
import com.turkcell.library_app_ddd_cqrs.application.customer.mapper.CustomerResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListCustomersPagedQueryHandler implements QueryHandler<ListCustomerPagedQuery, List<CustomerResponse>> {
	private final CustomerRepository customerRepository;
	private final CustomerResponseMapper customerResponseMapper;

	@Override
	public List<CustomerResponse> handle(ListCustomerPagedQuery query) {
		return customerRepository
				.findAllPaged(query.pageIndex(), query.pageSize())
				.stream()
				.map(customerResponseMapper::toResponse)
				.toList();
	}

}
