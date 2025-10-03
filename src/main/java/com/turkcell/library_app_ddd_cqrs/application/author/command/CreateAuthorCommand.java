package com.turkcell.library_app_ddd_cqrs.application.author.command;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.CreatedAuthorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAuthorCommand(
		@NotBlank @Size(max = 255) String name)
		implements Command<CreatedAuthorResponse> {
}