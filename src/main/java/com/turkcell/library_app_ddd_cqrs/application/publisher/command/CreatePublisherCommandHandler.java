package com.turkcell.library_app_ddd_cqrs.application.publisher.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.library_app_ddd_cqrs.application.publisher.mapper.CreatePublisherMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.model.Publisher;
import com.turkcell.library_app_ddd_cqrs.domain.publisher.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreatePublisherCommandHandler implements CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> {

	private final PublisherRepository publisherRepository;
	private final CreatePublisherMapper createPublisherMapper;

	@Override
	public CreatedPublisherResponse handle(CreatePublisherCommand command) {
		Publisher publisher = createPublisherMapper.toDomain(command);
		publisher = publisherRepository.save(publisher);
		return createPublisherMapper.toResponse(publisher);
	}
}

