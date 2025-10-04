package com.turkcell.library_app_ddd_cqrs.application.customer.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.customer.dto.DeletedCustomerResponse;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;

@Component
public class DeleteCustomerMapper {
	public DeletedCustomerResponse toResponse(Customer domain) {
		return new DeletedCustomerResponse(
				domain.getId().value(),
				domain.getName(),
				domain.getEmail(),
				domain.getPhone(),
				domain.getRegisterDate());
	}
}
