package com.turkcell.library_app_ddd_cqrs.application.publisher.query;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.PublisherResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotNull;

public record FindByIdPublisherQuery(
		@NotNull UUID id)
		implements Query<PublisherResponse> {

}

