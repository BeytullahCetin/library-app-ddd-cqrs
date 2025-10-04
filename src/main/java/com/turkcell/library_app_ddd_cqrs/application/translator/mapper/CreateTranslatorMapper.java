package com.turkcell.library_app_ddd_cqrs.application.translator.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.translator.command.CreateTranslatorCommand;
import com.turkcell.library_app_ddd_cqrs.application.translator.dto.CreatedTranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;

@Component
public class CreateTranslatorMapper {
	public Translator toDomain(CreateTranslatorCommand command) {
		return Translator.create(command.name());
	}

	public CreatedTranslatorResponse toResponse(Translator domain) {
		return new CreatedTranslatorResponse(
				domain.getId().value(),
				domain.getName());
	}
}
