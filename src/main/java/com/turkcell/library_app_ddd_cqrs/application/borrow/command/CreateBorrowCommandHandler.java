package com.turkcell.library_app_ddd_cqrs.application.borrow.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.CreatedBorrowResponse;
import com.turkcell.library_app_ddd_cqrs.application.borrow.mapper.CreateBorrowMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.Borrow;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.repository.BorrowRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateBorrowCommandHandler implements CommandHandler<CreateBorrowCommand, CreatedBorrowResponse> {

	private final BorrowRepository borrowRepository;
	private final CreateBorrowMapper createBorrowMapper;

	@Override
	public CreatedBorrowResponse handle(CreateBorrowCommand command) {
		Borrow borrow = createBorrowMapper.toDomain(command);
		borrow = borrowRepository.save(borrow);
		return createBorrowMapper.toResponse(borrow);
	}
}

