package com.turkcell.library_app_ddd_cqrs.application.borrow.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.BorrowResponse;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.Borrow;

@Component
public class BorrowResponseMapper {
	public BorrowResponse toResponse(Borrow domain) {
		return new BorrowResponse(
				domain.getId().value(),
				domain.getBorrowDate(),
				domain.getDueDate(),
				domain.getReturnDate(),
				domain.getCustomerId(),
				domain.getBookCopyId());
	}
}

