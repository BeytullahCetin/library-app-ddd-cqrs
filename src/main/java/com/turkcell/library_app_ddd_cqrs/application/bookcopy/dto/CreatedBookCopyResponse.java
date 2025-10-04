package com.turkcell.library_app_ddd_cqrs.application.bookcopy.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.core.enums.BookStatus;

public record CreatedBookCopyResponse(UUID id, LocalDateTime acquisitionDate, BookStatus bookStatus, UUID bookId) {
}

