package com.turkcell.library_app_ddd_cqrs.application.author.query;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.AuthorResponse;
import com.turkcell.library_app_ddd_cqrs.application.author.mapper.AuthorResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.AuthorId;
import com.turkcell.library_app_ddd_cqrs.domain.author.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdAuthorQueryHandler implements QueryHandler<FindByIdAuthorQuery, AuthorResponse> {
	private final AuthorRepository authorRepository;
	private final AuthorResponseMapper authorResponseMapper;

	@Override
	public AuthorResponse handle(FindByIdAuthorQuery query) {
		return authorResponseMapper.toResponse(authorRepository.findById(new AuthorId(query.id())).get());
	}

}
