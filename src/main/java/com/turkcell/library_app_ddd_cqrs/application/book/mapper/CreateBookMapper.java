package com.turkcell.library_app_ddd_cqrs.application.book.mapper;

import com.turkcell.library_app_ddd_cqrs.application.book.command.CreateBookCommand;
import com.turkcell.library_app_ddd_cqrs.application.book.dto.CreatedBookResponse;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;
import org.springframework.stereotype.Component;

@Component
public class CreateBookMapper {
    public Book toDomain(CreateBookCommand command) {
        return Book.create(command.title(),command.isbn(),command.pageCount(),command.publishDate());
    }

    public CreatedBookResponse toResponse(Book domain) {
        return new CreatedBookResponse(
                domain.getId().value(),
                domain.getIsbn(),
                domain.getTitle(),
                domain.getPageCount(),
                domain.getPublishDate());
    }
}