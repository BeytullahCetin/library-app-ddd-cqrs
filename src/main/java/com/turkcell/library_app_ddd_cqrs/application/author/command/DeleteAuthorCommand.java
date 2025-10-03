package com.turkcell.library_app_ddd_cqrs.application.author.command;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.DeletedAuthorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotBlank;

public record DeleteAuthorCommand(@NotBlank UUID id) implements Command<DeletedAuthorResponse> {

}
