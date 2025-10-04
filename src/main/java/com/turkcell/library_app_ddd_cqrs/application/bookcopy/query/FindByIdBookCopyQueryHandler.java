package com.turkcell.library_app_ddd_cqrs.application.bookcopy.query;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.BookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.application.bookcopy.mapper.BookCopyResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopyId;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.repository.BookCopyRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdBookCopyQueryHandler implements QueryHandler<FindByIdBookCopyQuery, BookCopyResponse> {
	private final BookCopyRepository bookCopyRepository;
	private final BookCopyResponseMapper bookCopyResponseMapper;

	@Override
	public BookCopyResponse handle(FindByIdBookCopyQuery query) {
		return bookCopyRepository
				.findById(new BookCopyId(query.id()))
				.map(bookCopyResponseMapper::toResponse)
				.orElseThrow(() -> new RuntimeException("BookCopy not found with id: " + query.id()));
	}

}

