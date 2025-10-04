package com.turkcell.library_app_ddd_cqrs.persistence.book;

import com.turkcell.library_app_ddd_cqrs.domain.book.repository.BookRepository;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.BookId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepository {
    private final SpringDataBookRepository repository;
    private final BookEntityMapper bookEntityMapper;

    @Override
    public Optional<Book> findById(BookId id) {
        return repository
                .findById(id.value())
                .map(bookEntityMapper::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return repository
                .findAll()
                .stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Book> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Book save(Book book) {
        JpaBookEntity entity = bookEntityMapper.toEntity(book);
        entity = repository.save(entity);
        return bookEntityMapper.toDomain(entity);
    }

    @Override
    public void delete(BookId id) {
        repository.deleteById(id.value());
    }
}
