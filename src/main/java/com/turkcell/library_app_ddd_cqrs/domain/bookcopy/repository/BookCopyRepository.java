package com.turkcell.library_app_ddd_cqrs.domain.bookcopy.repository;

import java.util.List;
import java.util.Optional;

import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopy;
import com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model.BookCopyId;

public interface BookCopyRepository {
	Optional<BookCopy> findById(BookCopyId id);

	List<BookCopy> findAll();

	List<BookCopy> findAllPaged(Integer pageIndex, Integer pageSize);

	BookCopy save(BookCopy bookCopy);

	void delete(BookCopyId id);
}

