package com.turkcell.library_app_ddd_cqrs.application.author.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.author.command.CreateAuthorCommand;
import com.turkcell.library_app_ddd_cqrs.application.author.dto.CreatedAuthorResponse;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;

@Component
public class CreateAuthorMapper {
	public Author toDomain(CreateAuthorCommand command) {
		return Author.create(command.name());
	}

	public CreatedAuthorResponse toResponse(Author domain) {
		return new CreatedAuthorResponse(
				domain.getId().value(),
				domain.getName());
	}
}
