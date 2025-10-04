package com.turkcell.library_app_ddd_cqrs.domain.author.repository;

import java.util.List;
import java.util.Optional;

import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.AuthorId;

public interface AuthorRepository {
	Optional<Author> findById(AuthorId id);

	List<Author> findAllPaged(Integer pageIndex, Integer pageSize);

	Author save(Author author);

	void delete(AuthorId id);
}
