package com.turkcell.library_app_ddd_cqrs.application.borrow.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.BorrowResponse;
import com.turkcell.library_app_ddd_cqrs.application.borrow.mapper.BorrowResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.repository.BorrowRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListBorrowsPagedQueryHandler implements QueryHandler<ListBorrowsPagedQuery, List<BorrowResponse>> {
	private final BorrowRepository borrowRepository;
	private final BorrowResponseMapper borrowResponseMapper;

	@Override
	public List<BorrowResponse> handle(ListBorrowsPagedQuery query) {
		return borrowRepository
				.findAllPaged(query.pageIndex(), query.pageSize())
				.stream()
				.map(borrowResponseMapper::toResponse)
				.toList();
	}

}

