package com.turkcell.library_app_ddd_cqrs.application.publisher.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.publisher.command.CreatePublisherCommand;
import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.Publisher;

@Component
public class CreatePublisherMapper {
	public Publisher toDomain(CreatePublisherCommand command) {
		return Publisher.create(command.name(), command.address());
	}

	public CreatedPublisherResponse toResponse(Publisher domain) {
		return new CreatedPublisherResponse(
				domain.getId().value(),
				domain.getName(),
				domain.getAddress());
	}
}

