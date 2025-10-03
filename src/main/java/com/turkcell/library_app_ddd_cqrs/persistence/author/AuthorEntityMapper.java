package com.turkcell.library_app_ddd_cqrs.persistence.author;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.AuthorId;

@Component
public class AuthorEntityMapper {
	public JpaAuthorEntity toEntity(Author domain) {
		JpaAuthorEntity entity = new JpaAuthorEntity();
		entity.setId(domain.getId().value());
		entity.setName(domain.getName());

		return entity;
	}

	public Author toDomain(JpaAuthorEntity entity) {
		return Author.rehydrate(new AuthorId(entity.getId()), entity.getName());
	}
}