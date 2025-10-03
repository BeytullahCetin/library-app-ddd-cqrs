package com.turkcell.library_app_ddd_cqrs.persistence.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;
import com.turkcell.library_app_ddd_cqrs.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

	private final SpringDataCustomerRepository repository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public Optional<Customer> findById(CustomerId id) {
		return repository
				.findById(id.value())
				.map(customerEntityMapper::toDomain);
	}

	@Override
	public List<Customer> findAll() {
		return repository
				.findAll()
				.stream()
				.map(customerEntityMapper::toDomain)
				.toList();
	}

	@Override
	public List<Customer> findAllPaged(Integer pageIndex, Integer pageSize) {
		return repository
				.findAll(PageRequest.of(pageIndex, pageSize))
				.stream()
				.map(customerEntityMapper::toDomain)
				.toList();
	}

	@Override
	public Customer save(Customer customer) {
		JpaCustomerEntity entity = customerEntityMapper.toEntity(customer);
		entity = repository.save(entity);
		return customerEntityMapper.toDomain(entity);
	}

	@Override
	public void delete(CustomerId id) {
		repository.deleteById(id.value());
	}

}
