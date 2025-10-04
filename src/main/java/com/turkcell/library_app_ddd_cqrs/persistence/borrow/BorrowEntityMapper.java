package com.turkcell.library_app_ddd_cqrs.persistence.borrow;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.Borrow;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.BorrowId;

@Component
public class BorrowEntityMapper {
	public JpaBorrowEntity toEntity(Borrow domain) {
		JpaBorrowEntity entity = new JpaBorrowEntity();
		entity.setId(domain.getId().value());
		entity.setBorrowDate(domain.getBorrowDate());
		entity.setDueDate(domain.getDueDate());
		entity.setReturnDate(domain.getReturnDate());
		entity.setCustomerId(domain.getCustomerId());
		entity.setBookCopyId(domain.getBookCopyId());

		return entity;
	}

	public Borrow toDomain(JpaBorrowEntity entity) {
		return Borrow.rehydrate(
				new BorrowId(entity.getId()),
				entity.getBorrowDate(),
				entity.getDueDate(),
				entity.getReturnDate(),
				entity.getCustomerId(),
				entity.getBookCopyId());
	}
}

