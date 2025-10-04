package com.turkcell.library_app_ddd_cqrs.interfaces.web;

import com.turkcell.library_app_ddd_cqrs.application.book.command.CreateBookCommand;
import com.turkcell.library_app_ddd_cqrs.application.book.dto.BookResponse;
import com.turkcell.library_app_ddd_cqrs.application.book.dto.CreatedBookResponse;
import com.turkcell.library_app_ddd_cqrs.application.book.query.FindByIdBookQuery;
import com.turkcell.library_app_ddd_cqrs.application.book.query.ListBooksPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class BookController {
    private final QueryHandler<ListBooksPagedQuery, List<BookResponse>> listBookQueryHandler;
    private final QueryHandler<FindByIdBookQuery, BookResponse> findByIdBookQueryHandler;
    private final CommandHandler<CreateBookCommand, CreatedBookResponse> createBookQueryHandler;

    public BookController(QueryHandler<ListBooksPagedQuery, List<BookResponse>> listBookQueryHandler,
            QueryHandler<FindByIdBookQuery, BookResponse> findByIdBookQueryHandler,
            CommandHandler<CreateBookCommand, CreatedBookResponse> createBookQueryHandler) {
        this.listBookQueryHandler = listBookQueryHandler;
        this.findByIdBookQueryHandler = findByIdBookQueryHandler;
        this.createBookQueryHandler = createBookQueryHandler;
    }

    @GetMapping("/v1/books")
    public List<BookResponse> getBooksPaged(@Valid ListBooksPagedQuery query) {
        return listBookQueryHandler.handle(query);
    }

    @GetMapping("/v1/books/{id}")
    public BookResponse getBooksPaged(@Valid FindByIdBookQuery query) {
        return findByIdBookQueryHandler.handle(query);
    }

    @PostMapping("/v1/books")
    public CreatedBookResponse createBook(@RequestBody CreateBookCommand command) {
        return createBookQueryHandler.handle(command);
    }

}
