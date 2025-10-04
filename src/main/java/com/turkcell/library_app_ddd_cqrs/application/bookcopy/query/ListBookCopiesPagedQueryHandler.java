package com.turkcell.library_app_ddd_cqrs.application.bookcopy.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.BookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.application.bookcopy.mapper.BookCopyResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.repository.BookCopyRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListBookCopiesPagedQueryHandler
		implements QueryHandler<ListBookCopiesPagedQuery, List<BookCopyResponse>> {
	private final BookCopyRepository bookCopyRepository;
	private final BookCopyResponseMapper bookCopyResponseMapper;

	@Override
	public List<BookCopyResponse> handle(ListBookCopiesPagedQuery query) {
		return bookCopyRepository
				.findAllPaged(query.pageIndex(), query.pageSize())
				.stream()
				.map(bookCopyResponseMapper::toResponse)
				.toList();
	}

}

