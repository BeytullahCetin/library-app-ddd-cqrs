package com.turkcell.library_app_ddd_cqrs.application.publisher.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.PublisherResponse;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.Publisher;

@Component
public class PublisherResponseMapper {
	public PublisherResponse toResponse(Publisher domain) {
		return new PublisherResponse(
				domain.getId().value(),
				domain.getName(),
				domain.getAddress());
	}
}

