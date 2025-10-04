package com.turkcell.library_app_ddd_cqrs.interfaces.web;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app_ddd_cqrs.application.publisher.command.CreatePublisherCommand;
import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.PublisherResponse;
import com.turkcell.library_app_ddd_cqrs.application.publisher.query.FindByIdPublisherQuery;
import com.turkcell.library_app_ddd_cqrs.application.publisher.query.ListPublishersPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class PublisherController {
	private final QueryHandler<ListPublishersPagedQuery, List<PublisherResponse>> listPublisherQueryHandler;
	private final QueryHandler<FindByIdPublisherQuery, PublisherResponse> findByIdPublisherQueryHandler;
	private final CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> createPublisherCommandHandler;

	public PublisherController(
			QueryHandler<ListPublishersPagedQuery, List<PublisherResponse>> listPublisherQueryHandler,
			QueryHandler<FindByIdPublisherQuery, PublisherResponse> findByIdPublisherQueryHandler,
			CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> createPublisherCommandHandler) {
		this.listPublisherQueryHandler = listPublisherQueryHandler;
		this.findByIdPublisherQueryHandler = findByIdPublisherQueryHandler;
		this.createPublisherCommandHandler = createPublisherCommandHandler;
	}

	@GetMapping("/v1/publishers")
	public List<PublisherResponse> getPublishersPaged(@Valid ListPublishersPagedQuery query) {
		return listPublisherQueryHandler.handle(query);
	}

	@GetMapping("/v1/publishers/{id}")
	public PublisherResponse getPublisherById(@Valid FindByIdPublisherQuery query) {
		return findByIdPublisherQueryHandler.handle(query);
	}

	@PostMapping("/v1/publishers")
	public CreatedPublisherResponse createPublisher(@RequestBody @Valid CreatePublisherCommand command) {
		return createPublisherCommandHandler.handle(command);
	}

}

