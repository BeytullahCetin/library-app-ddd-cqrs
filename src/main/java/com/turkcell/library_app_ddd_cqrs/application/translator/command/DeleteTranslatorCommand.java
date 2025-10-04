package com.turkcell.library_app_ddd_cqrs.application.translator.command;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.DeletedTranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotBlank;

public record DeleteTranslatorCommand(
		@NotBlank UUID id)
		implements Command<DeletedTranslatorResponse> {
}
