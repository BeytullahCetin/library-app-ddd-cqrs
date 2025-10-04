package com.turkcell.library_app_ddd_cqrs.persistence.borrow;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.Borrow;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.BorrowId;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.repository.BorrowRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BorrowRepositoryAdapter implements BorrowRepository {

	private final SpringDataBorrowRepository repository;
	private final BorrowEntityMapper borrowEntityMapper;

	@Override
	public Optional<Borrow> findById(BorrowId id) {
		return repository
				.findById(id.value())
				.map(borrowEntityMapper::toDomain);
	}

	@Override
	public List<Borrow> findAll() {
		return repository
				.findAll()
				.stream()
				.map(borrowEntityMapper::toDomain)
				.toList();
	}

	@Override
	public List<Borrow> findAllPaged(Integer pageIndex, Integer pageSize) {
		return repository
				.findAll(PageRequest.of(pageIndex, pageSize))
				.stream()
				.map(borrowEntityMapper::toDomain)
				.toList();
	}

	@Override
	public List<Borrow> findByCustomerId(UUID customerId) {
		return repository
				.findByCustomerId(customerId)
				.stream()
				.map(borrowEntityMapper::toDomain)
				.toList();
	}

	@Override
	public Borrow save(Borrow borrow) {
		JpaBorrowEntity entity = borrowEntityMapper.toEntity(borrow);
		entity = repository.save(entity);
		return borrowEntityMapper.toDomain(entity);
	}

	@Override
	public void delete(BorrowId id) {
		repository.deleteById(id.value());
	}

}

