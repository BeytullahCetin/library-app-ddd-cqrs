package com.turkcell.library_app_ddd_cqrs.persistence.bookcopy;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopy;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopyId;

@Component
public class BookCopyEntityMapper {
	public JpaBookCopyEntity toEntity(BookCopy domain) {
		JpaBookCopyEntity entity = new JpaBookCopyEntity();
		entity.setId(domain.getId().value());
		entity.setAcquisitionDate(domain.getAcquisitionDate());
		entity.setBookStatus(domain.getBookStatus());
		entity.setBookId(domain.getBookId());

		return entity;
	}

	public BookCopy toDomain(JpaBookCopyEntity entity) {
		return BookCopy.rehydrate(
				new BookCopyId(entity.getId()),
				entity.getAcquisitionDate(),
				entity.getBookStatus(),
				entity.getBookId());
	}
}

