package com.turkcell.library_app_ddd_cqrs.application.book.command;


import com.turkcell.library_app_ddd_cqrs.application.book.dto.DeletedBookResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record DeleteBookCommand(@NotBlank UUID id) implements Command<DeletedBookResponse> {
}
