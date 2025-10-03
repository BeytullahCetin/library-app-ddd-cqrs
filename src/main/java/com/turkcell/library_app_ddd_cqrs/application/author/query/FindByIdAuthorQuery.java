package com.turkcell.library_app_ddd_cqrs.application.author.query;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.AuthorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotBlank;

public record FindByIdAuthorQuery(@NotBlank UUID id) implements Query<AuthorResponse> {

}
