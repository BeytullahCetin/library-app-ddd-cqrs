package com.turkcell.library_app_ddd_cqrs.application.borrow.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record BorrowResponse(UUID id, LocalDateTime borrowDate, LocalDateTime dueDate, LocalDateTime returnDate,
		UUID customerId, UUID bookCopyId) {
}

