package com.turkcell.library_app_ddd_cqrs.domain.customer.repository;

import java.util.List;
import java.util.Optional;

import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;

public interface CustomerRepository {
	Optional<Customer> findById(CustomerId id);

	List<Customer> findAllPaged(Integer pageIndex, Integer pageSize);

	Customer save(Customer customer);

	void delete(CustomerId id);
}
