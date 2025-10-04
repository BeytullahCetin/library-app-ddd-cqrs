package com.turkcell.library_app_ddd_cqrs.application.borrow.command;

import java.time.LocalDateTime;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.CreatedBorrowResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotNull;

public record CreateBorrowCommand(
		@NotNull LocalDateTime borrowDate,
		@NotNull LocalDateTime dueDate,
		LocalDateTime returnDate,
		@NotNull UUID customerId,
		@NotNull UUID bookCopyId)
		implements Command<CreatedBorrowResponse> {
}

