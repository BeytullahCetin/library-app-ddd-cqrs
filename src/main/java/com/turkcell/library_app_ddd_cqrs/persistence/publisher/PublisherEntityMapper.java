package com.turkcell.library_app_ddd_cqrs.persistence.publisher;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.Publisher;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.PublisherId;

@Component
public class PublisherEntityMapper {
	public JpaPublisherEntity toEntity(Publisher domain) {
		JpaPublisherEntity entity = new JpaPublisherEntity();
		entity.setId(domain.getId().value());
		entity.setName(domain.getName());
		entity.setAddress(domain.getAddress());

		return entity;
	}

	public Publisher toDomain(JpaPublisherEntity entity) {
		return Publisher.rehydrate(
				new PublisherId(entity.getId()),
				entity.getName(),
				entity.getAddress());
	}
}

