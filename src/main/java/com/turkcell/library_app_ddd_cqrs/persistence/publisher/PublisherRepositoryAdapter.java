package com.turkcell.library_app_ddd_cqrs.persistence.publisher;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.Publisher;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.PublisherId;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PublisherRepositoryAdapter implements PublisherRepository {

	private final SpringDataPublisherRepository repository;
	private final PublisherEntityMapper publisherEntityMapper;

	@Override
	public Optional<Publisher> findById(PublisherId id) {
		return repository
				.findById(id.value())
				.map(publisherEntityMapper::toDomain);
	}

	@Override
	public List<Publisher> findAll() {
		return repository
				.findAll()
				.stream()
				.map(publisherEntityMapper::toDomain)
				.toList();
	}

	@Override
	public List<Publisher> findAllPaged(Integer pageIndex, Integer pageSize) {
		return repository
				.findAll(PageRequest.of(pageIndex, pageSize))
				.stream()
				.map(publisherEntityMapper::toDomain)
				.toList();
	}

	@Override
	public Publisher save(Publisher publisher) {
		JpaPublisherEntity entity = publisherEntityMapper.toEntity(publisher);
		entity = repository.save(entity);
		return publisherEntityMapper.toDomain(entity);
	}

	@Override
	public void delete(PublisherId id) {
		repository.deleteById(id.value());
	}

}

