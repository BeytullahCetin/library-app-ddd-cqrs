package com.turkcell.library_app_ddd_cqrs.domain.publisher.repository;

import java.util.List;
import java.util.Optional;

import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.Publisher;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.PublisherId;

public interface PublisherRepository {
	Optional<Publisher> findById(PublisherId id);

	List<Publisher> findAll();

	List<Publisher> findAllPaged(Integer pageIndex, Integer pageSize);

	Publisher save(Publisher publisher);

	void delete(PublisherId id);
}

