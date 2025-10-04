package com.turkcell.library_app_ddd_cqrs.persistence.bookcopy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopy;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopyId;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.repository.BookCopyRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookCopyRepositoryAdapter implements BookCopyRepository {

	private final SpringDataBookCopyRepository repository;
	private final BookCopyEntityMapper bookCopyEntityMapper;

	@Override
	public Optional<BookCopy> findById(BookCopyId id) {
		return repository
				.findById(id.value())
				.map(bookCopyEntityMapper::toDomain);
	}

	@Override
	public List<BookCopy> findAll() {
		return repository
				.findAll()
				.stream()
				.map(bookCopyEntityMapper::toDomain)
				.toList();
	}

	@Override
	public List<BookCopy> findAllPaged(Integer pageIndex, Integer pageSize) {
		return repository
				.findAll(PageRequest.of(pageIndex, pageSize))
				.stream()
				.map(bookCopyEntityMapper::toDomain)
				.toList();
	}

	@Override
	public BookCopy save(BookCopy bookCopy) {
		JpaBookCopyEntity entity = bookCopyEntityMapper.toEntity(bookCopy);
		entity = repository.save(entity);
		return bookCopyEntityMapper.toDomain(entity);
	}

	@Override
	public void delete(BookCopyId id) {
		repository.deleteById(id.value());
	}

}

