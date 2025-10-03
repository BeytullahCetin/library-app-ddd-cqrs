package com.turkcell.library_app_ddd_cqrs.application.author.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.AuthorResponse;
import com.turkcell.library_app_ddd_cqrs.application.author.mapper.AuthorResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.author.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListAuthorsPagedQueryHandler implements QueryHandler<ListAuthorsPagedQuery, List<AuthorResponse>> {
	private final AuthorRepository authorRepository;
	private final AuthorResponseMapper authorResponseMapper;

	@Override
	public List<AuthorResponse> handle(ListAuthorsPagedQuery query) {
		return authorRepository
				.findAllPaged(query.pageIndex(), query.pageSize())
				.stream()
				.map(authorResponseMapper::toResponse)
				.toList();
	}

}
