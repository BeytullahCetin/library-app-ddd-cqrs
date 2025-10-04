package com.turkcell.library_app_ddd_cqrs.application.translator.command;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.CreatedTranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotBlank;

public record CreateTranslatorCommand(
		@NotBlank String name)
		implements Command<CreatedTranslatorResponse> {
}
