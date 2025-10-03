package com.turkcell.library_app_ddd_cqrs.interfaces.web;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app_ddd_cqrs.application.author.command.CreateAuthorCommand;
import com.turkcell.library_app_ddd_cqrs.application.author.dto.AuthorResponse;
import com.turkcell.library_app_ddd_cqrs.application.author.dto.CreatedAuthorResponse;
import com.turkcell.library_app_ddd_cqrs.application.author.query.FindByIdAuthorQuery;
import com.turkcell.library_app_ddd_cqrs.application.author.query.ListAuthorsPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@Validated
public class AuthorController {
	private final QueryHandler<ListAuthorsPagedQuery, List<AuthorResponse>> listAuthorQueryHandler;
	private final QueryHandler<FindByIdAuthorQuery, AuthorResponse> findByIdAuthorQueryHandler;
	private final CommandHandler<CreateAuthorCommand, CreatedAuthorResponse> createAuthorQueryHandler;

	public AuthorController(QueryHandler<ListAuthorsPagedQuery, List<AuthorResponse>> listAuthorQueryHandler,
			QueryHandler<FindByIdAuthorQuery, AuthorResponse> findByIdAuthorQueryHandler,
			CommandHandler<CreateAuthorCommand, CreatedAuthorResponse> createAuthorQueryHandler) {
		this.listAuthorQueryHandler = listAuthorQueryHandler;
		this.findByIdAuthorQueryHandler = findByIdAuthorQueryHandler;
		this.createAuthorQueryHandler = createAuthorQueryHandler;
	}

	@GetMapping("/v1/authors")
	public List<AuthorResponse> getAuthorsPaged(@Valid ListAuthorsPagedQuery query) {
		return listAuthorQueryHandler.handle(query);
	}

	@GetMapping("/v1/authors")
	public AuthorResponse getAuthorsPaged(@Valid FindByIdAuthorQuery query) {
		return findByIdAuthorQueryHandler.handle(query);
	}

	@PostMapping("/v1/authors")
	public CreatedAuthorResponse createAuthor(@RequestBody CreateAuthorCommand command) {
		return createAuthorQueryHandler.handle(command);
	}

}
