package com.turkcell.library_app_ddd_cqrs.application.book.query;

import com.turkcell.library_app_ddd_cqrs.application.book.dto.BookResponse;
import com.turkcell.library_app_ddd_cqrs.application.book.mapper.BookResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.BookId;
import com.turkcell.library_app_ddd_cqrs.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByIdBookQueryHandler implements QueryHandler<FindByIdBookQuery, BookResponse> {
    private final BookRepository bookRepository;
    private final BookResponseMapper bookResponseMapper;

    @Override
    public BookResponse handle(FindByIdBookQuery query) {
        return bookResponseMapper.toResponse(bookRepository.findById(new BookId(query.id())).get());
    }

}