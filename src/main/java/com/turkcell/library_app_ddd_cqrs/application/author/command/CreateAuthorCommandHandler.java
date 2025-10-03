package com.turkcell.library_app_ddd_cqrs.application.author.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.CreatedAuthorResponse;
import com.turkcell.library_app_ddd_cqrs.application.author.mapper.CreateAuthorMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;
import com.turkcell.library_app_ddd_cqrs.domain.author.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateAuthorCommandHandler implements CommandHandler<CreateAuthorCommand, CreatedAuthorResponse> {

	private final AuthorRepository authorRepository;
	private final CreateAuthorMapper createAuthorMapper;

	@Override
	public CreatedAuthorResponse handle(CreateAuthorCommand command) {
		Author author = createAuthorMapper.toDomain(command);
		author = authorRepository.save(author);
		return createAuthorMapper.toResponse(author);
	}
}
