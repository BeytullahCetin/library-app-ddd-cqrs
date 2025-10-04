package com.turkcell.library_app_ddd_cqrs.domain.borrow.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.Borrow;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.BorrowId;

public interface BorrowRepository {
	Optional<Borrow> findById(BorrowId id);

	List<Borrow> findAll();

	List<Borrow> findAllPaged(Integer pageIndex, Integer pageSize);

	List<Borrow> findByCustomerId(UUID customerId);

	Borrow save(Borrow borrow);

	void delete(BorrowId id);
}

