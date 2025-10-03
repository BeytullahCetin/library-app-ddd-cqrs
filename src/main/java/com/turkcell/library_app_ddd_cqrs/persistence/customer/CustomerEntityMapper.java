package com.turkcell.library_app_ddd_cqrs.persistence.customer;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;

@Component
public class CustomerEntityMapper {
	public JpaCustomerEntity toEntity(Customer domain) {
		JpaCustomerEntity entity = new JpaCustomerEntity();
		entity.setId(domain.getId().value());
		entity.setName(domain.getName());
		entity.setPhone(domain.getPhone());
		entity.setEmail(domain.getEmail());
		entity.setRegisterDate(domain.getRegisterDate());

		return entity;
	}

	public Customer toDomain(JpaCustomerEntity entity) {
		return Customer.rehydrate(new CustomerId(entity.getId()),
				entity.getName(),
				entity.getEmail(),
				entity.getPhone(),
				entity.getRegisterDate());
	}
}