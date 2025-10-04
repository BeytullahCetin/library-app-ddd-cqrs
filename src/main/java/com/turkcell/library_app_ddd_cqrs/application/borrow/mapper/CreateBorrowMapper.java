package com.turkcell.library_app_ddd_cqrs.application.borrow.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.borrow.command.CreateBorrowCommand;
import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.CreatedBorrowResponse;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.Borrow;

@Component
public class CreateBorrowMapper {
	public Borrow toDomain(CreateBorrowCommand command) {
		return Borrow.create(
				command.borrowDate(),
				command.dueDate(),
				command.returnDate(),
				command.customerId(),
				command.bookCopyId());
	}

	public CreatedBorrowResponse toResponse(Borrow domain) {
		return new CreatedBorrowResponse(
				domain.getId().value(),
				domain.getBorrowDate(),
				domain.getDueDate(),
				domain.getReturnDate(),
				domain.getCustomerId(),
				domain.getBookCopyId());
	}
}

