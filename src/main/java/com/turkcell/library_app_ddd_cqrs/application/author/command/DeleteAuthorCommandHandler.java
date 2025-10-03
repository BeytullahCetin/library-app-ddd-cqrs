package com.turkcell.library_app_ddd_cqrs.application.author.command;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.DeletedAuthorResponse;
import com.turkcell.library_app_ddd_cqrs.application.author.mapper.DeleteAuthorMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.AuthorId;
import com.turkcell.library_app_ddd_cqrs.domain.author.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteAuthorCommandHandler implements CommandHandler<DeleteAuthorCommand, DeletedAuthorResponse> {

	private final AuthorRepository authorRepository;
	private final DeleteAuthorMapper deleteAuthorMapper;

	@Override
	public DeletedAuthorResponse handle(DeleteAuthorCommand command) {
		Optional<Author> author = authorRepository.findById(new AuthorId(command.id()));

		if (author == null) {
			throw new IllegalArgumentException("Bu id ile bir author bulunamadı!");
		}

		authorRepository.delete(author.get().getId());
		return deleteAuthorMapper.toResponse(author.get());
	}
}
