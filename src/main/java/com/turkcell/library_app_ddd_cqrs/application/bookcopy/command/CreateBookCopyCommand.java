package com.turkcell.library_app_ddd_cqrs.application.bookcopy.command;

import java.time.LocalDateTime;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto.CreatedBookCopyResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;
import com.turkcell.library_app_ddd_cqrs.core.enums.BookStatus;

import jakarta.validation.constraints.NotNull;

public record CreateBookCopyCommand(
		@NotNull LocalDateTime acquisitionDate,
		@NotNull BookStatus bookStatus,
		@NotNull UUID bookId)
		implements Command<CreatedBookCopyResponse> {
}

