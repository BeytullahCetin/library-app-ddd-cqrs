package com.turkcell.library_app_ddd_cqrs.application.book.command;

import com.turkcell.library_app_ddd_cqrs.application.book.dto.CreatedBookResponse;
import com.turkcell.library_app_ddd_cqrs.application.book.mapper.CreateBookMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;
import com.turkcell.library_app_ddd_cqrs.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBookCommandHandler implements CommandHandler<CreateBookCommand, CreatedBookResponse> {

    private final BookRepository bookRepository;
    private final CreateBookMapper createBookMapper;

    @Override
    public CreatedBookResponse handle(CreateBookCommand command) {
        Book book = createBookMapper.toDomain(command);
        book = bookRepository.save(book);
        return createBookMapper.toResponse(book);
    }
}
