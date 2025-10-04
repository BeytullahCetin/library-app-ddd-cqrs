package com.turkcell.library_app_ddd_cqrs.application.bookcopy.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.CreatedBookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.application.bookcopy.mapper.CreateBookCopyMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopy;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.repository.BookCopyRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateBookCopyCommandHandler implements CommandHandler<CreateBookCopyCommand, CreatedBookCopyResponse> {

	private final BookCopyRepository bookCopyRepository;
	private final CreateBookCopyMapper createBookCopyMapper;

	@Override
	public CreatedBookCopyResponse handle(CreateBookCopyCommand command) {
		BookCopy bookCopy = createBookCopyMapper.toDomain(command);
		bookCopy = bookCopyRepository.save(bookCopy);
		return createBookCopyMapper.toResponse(bookCopy);
	}
}

