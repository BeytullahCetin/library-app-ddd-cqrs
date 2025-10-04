package com.turkcell.library_app_ddd_cqrs.application.publisher.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.PublisherResponse;
import com.turkcell.library_app_ddd_cqrs.application.publisher.mapper.PublisherResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListPublishersPagedQueryHandler implements QueryHandler<ListPublishersPagedQuery, List<PublisherResponse>> {
	private final PublisherRepository publisherRepository;
	private final PublisherResponseMapper publisherResponseMapper;

	@Override
	public List<PublisherResponse> handle(ListPublishersPagedQuery query) {
		return publisherRepository
				.findAllPaged(query.pageIndex(), query.pageSize())
				.stream()
				.map(publisherResponseMapper::toResponse)
				.toList();
	}

}

