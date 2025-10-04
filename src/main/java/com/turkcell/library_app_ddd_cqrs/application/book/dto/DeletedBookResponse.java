package com.turkcell.library_app_ddd_cqrs.application.book.dto;

import java.time.LocalDate;
import java.util.UUID;

public record DeletedBookResponse(UUID id, String title, String isbn, int pageCount, LocalDate publishDate) {
}
