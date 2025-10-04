package com.turkcell.library_app_ddd_cqrs.application.book.mapper;

import com.turkcell.library_app_ddd_cqrs.application.book.dto.DeletedBookResponse;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookMapper {

    public DeletedBookResponse toResponse(Book domain) {
        return new DeletedBookResponse(domain.getId().value(), domain.getTitle(),domain.getIsbn(),domain.getPageCount(),domain.getPublishDate());
    }
}
