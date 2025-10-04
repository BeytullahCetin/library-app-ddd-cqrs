package com.turkcell.library_app_ddd_cqrs.application.book.command;

import com.turkcell.library_app_ddd_cqrs.application.book.dto.CreatedBookResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateBookCommand(
        @NotBlank @Size(max = 255) String title,
        @NotBlank @Size(max = 255) String isbn,
        @Positive int pageCount,
        LocalDate publishDate)
        implements Command<CreatedBookResponse> {
	
}
