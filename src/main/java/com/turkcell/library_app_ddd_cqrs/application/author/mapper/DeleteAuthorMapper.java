package com.turkcell.library_app_ddd_cqrs.application.author.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.author.dto.DeletedAuthorResponse;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;

@Component
public class DeleteAuthorMapper {

	public DeletedAuthorResponse toResponse(Author domain) {
		return new DeletedAuthorResponse(domain.getId().value(), domain.getName());
	}
}
