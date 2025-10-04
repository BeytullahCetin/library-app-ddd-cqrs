package com.turkcell.library_app_ddd_cqrs.application.bookcopy.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.BookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopy;

@Component
public class BookCopyResponseMapper {
	public BookCopyResponse toResponse(BookCopy domain) {
		return new BookCopyResponse(
				domain.getId().value(),
				domain.getAcquisitionDate(),
				domain.getBookStatus(),
				domain.getBookId());
	}
}

