package com.turkcell.library_app_ddd_cqrs.application.publisher.query;

import java.util.List;

import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.PublisherResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.Min;

public record ListPublishersPagedQuery(
		@Min(0) Integer pageIndex,
		@Min(1) Integer pageSize)
		implements Query<List<PublisherResponse>> {

}

