package com.turkcell.library_app_ddd_cqrs.persistence.author;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.turkcell.library_app_ddd_cqrs.domain.author.model.Author;
import com.turkcell.library_app_ddd_cqrs.domain.author.model.AuthorId;
import com.turkcell.library_app_ddd_cqrs.domain.author.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryAdapter implements AuthorRepository {

	private final SpringDataAuthorRepository repository;
	private final AuthorEntityMapper authorEntityMapper;

	@Override
	public Optional<Author> findById(AuthorId id) {
		return repository
				.findById(id.value())
				.map(authorEntityMapper::toDomain);
	}

	@Override
	public List<Author> findAllPaged(Integer pageIndex, Integer pageSize) {
		return repository
				.findAll(PageRequest.of(pageIndex, pageSize))
				.stream()
				.map(authorEntityMapper::toDomain)
				.toList();
	}

	@Override
	public Author save(Author author) {
		JpaAuthorEntity entity = authorEntityMapper.toEntity(author);
		entity = repository.save(entity);
		return authorEntityMapper.toDomain(entity);
	}

	@Override
	public void delete(AuthorId id) {
		repository.deleteById(id.value());
	}

}
