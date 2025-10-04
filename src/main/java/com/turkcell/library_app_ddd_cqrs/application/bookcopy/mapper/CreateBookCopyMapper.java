package com.turkcell.library_app_ddd_cqrs.application.bookcopy.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.command.CreateBookCopyCommand;
import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.CreatedBookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopy;

@Component
public class CreateBookCopyMapper {
	public BookCopy toDomain(CreateBookCopyCommand command) {
		return BookCopy.create(
				command.acquisitionDate(),
				command.bookStatus(),
				command.bookId());
	}

	public CreatedBookCopyResponse toResponse(BookCopy domain) {
		return new CreatedBookCopyResponse(
				domain.getId().value(),
				domain.getAcquisitionDate(),
				domain.getBookStatus(),
				domain.getBookId());
	}
}

