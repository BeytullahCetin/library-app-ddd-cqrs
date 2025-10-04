package com.turkcell.library_app_ddd_cqrs.application.book.mapper;

import com.turkcell.library_app_ddd_cqrs.application.book.dto.BookResponse;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;

public class BookResponseMapper {
    public BookResponse toResponse(Book domain) {
        return new BookResponse(
                domain.getId().value(),
                domain.getTitle(),
                domain.getIsbn(),
                domain.getPageCount(),
                domain.getPublishDate());
    }
}
