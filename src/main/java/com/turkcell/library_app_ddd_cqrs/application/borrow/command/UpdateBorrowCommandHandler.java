package com.turkcell.library_app_ddd_cqrs.application.borrow.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.UpdatedBorrowResponse;
import com.turkcell.library_app_ddd_cqrs.application.borrow.mapper.UpdateBorrowMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.Borrow;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.model.BorrowId;
import com.turkcell.library_app_ddd_cqrs.domain.borrow.repository.BorrowRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateBorrowCommandHandler implements CommandHandler<UpdateBorrowCommand, UpdatedBorrowResponse> {

	private final BorrowRepository borrowRepository;
	private final UpdateBorrowMapper updateBorrowMapper;

	@Override
	public UpdatedBorrowResponse handle(UpdateBorrowCommand command) {
		Borrow borrow = borrowRepository.findById(new BorrowId(command.id()))
				.orElseThrow(() -> new RuntimeException("Borrow not found with id: " + command.id()));

		borrow.updateBorrowDate(command.borrowDate());
		borrow.updateDueDate(command.dueDate());
		if (command.returnDate() != null) {
			borrow.returnBook(command.returnDate());
		}

		borrow = borrowRepository.save(borrow);
		return updateBorrowMapper.toResponse(borrow);
	}
}

