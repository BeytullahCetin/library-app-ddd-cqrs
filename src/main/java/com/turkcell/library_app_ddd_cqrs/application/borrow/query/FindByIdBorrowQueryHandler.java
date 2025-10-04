package com.turkcell.library_app_ddd_cqrs.application.borrow.query;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.BorrowResponse;
import com.turkcell.library_app_ddd_cqrs.application.borrow.mapper.BorrowResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.BorrowId;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.repository.BorrowRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdBorrowQueryHandler implements QueryHandler<FindByIdBorrowQuery, BorrowResponse> {
	private final BorrowRepository borrowRepository;
	private final BorrowResponseMapper borrowResponseMapper;

	@Override
	public BorrowResponse handle(FindByIdBorrowQuery query) {
		return borrowRepository
				.findById(new BorrowId(query.id()))
				.map(borrowResponseMapper::toResponse)
				.orElseThrow(() -> new RuntimeException("Borrow not found with id: " + query.id()));
	}

}

