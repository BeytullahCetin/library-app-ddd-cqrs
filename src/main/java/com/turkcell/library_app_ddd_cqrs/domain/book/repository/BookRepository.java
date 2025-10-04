package com.turkcell.library_app_ddd_cqrs.domain.book.repository;

import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.BookId;


import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(BookId id);

    List<Book> findAll();

    List<Book> findAllPaged(Integer pageIndex, Integer pageSize);

    Book save(Book customer);

    void delete(BookId id);
	
}
