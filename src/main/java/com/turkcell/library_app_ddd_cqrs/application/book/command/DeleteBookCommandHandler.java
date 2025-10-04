package com.turkcell.library_app_ddd_cqrs.application.book.command;


import com.turkcell.library_app_ddd_cqrs.application.book.dto.DeletedBookResponse;
import com.turkcell.library_app_ddd_cqrs.application.book.mapper.DeleteBookMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.BookId;
import com.turkcell.library_app_ddd_cqrs.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteBookCommandHandler implements CommandHandler<DeleteBookCommand, DeletedBookResponse> {

    private final BookRepository bookRepository;
    private final DeleteBookMapper deleteBookMapper;

    @Override
    public DeletedBookResponse handle(DeleteBookCommand command) {
        Optional<Book> book = bookRepository.findById(new BookId(command.id()));

        if (book == null) {
            throw new IllegalArgumentException("Bu id ile bir book bulunamadı!");
        }

        bookRepository.delete(book.get().getId());
        return deleteBookMapper.toResponse(book.get());
    }
}