package com.turkcell.library_app_ddd_cqrs.application.author.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.AuthorResponse;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;

@Component
public class AuthorResponseMapper {
	public AuthorResponse toResponse(Author domain) {
		return new AuthorResponse(
				domain.getId().value(),
				domain.getName());
	}
}
