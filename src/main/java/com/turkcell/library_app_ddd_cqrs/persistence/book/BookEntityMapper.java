package com.turkcell.library_app_ddd_cqrs.persistence.book;

import com.turkcell.library_app_ddd_cqrs.domain.book.model.Book;
import com.turkcell.library_app_ddd_cqrs.domain.book.model.BookId;
import org.springframework.stereotype.Component;

@Component
public class BookEntityMapper {
    public JpaBookEntity toEntity(Book domain) {
        JpaBookEntity entity = new JpaBookEntity();
        entity.setId(domain.getId().value());
        entity.setIsbn(domain.getIsbn());
        entity.setPageCount(domain.getPageCount());
        entity.setPublishDate(domain.getPublishDate());
        entity.setTitle(domain.getTitle());
       return entity;
    }

    public Book toDomain(JpaBookEntity entity) {
        return Book.rehydrate(new BookId(entity.getId()),
                entity.getTitle(),
                entity.getIsbn(),
                entity.getPageCount(),
                entity.getPublishDate());

    }
}
