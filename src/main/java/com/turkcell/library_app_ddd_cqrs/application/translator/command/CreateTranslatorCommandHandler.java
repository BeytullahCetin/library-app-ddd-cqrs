package com.turkcell.library_app_ddd_cqrs.application.translator.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.CreatedTranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.application.translator.mapper.CreateTranslatorMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;
import com.turkcell.library_app_ddd_cqrs.domain.translator.repository.TranslatorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateTranslatorCommandHandler
		implements CommandHandler<CreateTranslatorCommand, CreatedTranslatorResponse> {

	private final TranslatorRepository translatorRepository;
	private final CreateTranslatorMapper createTranslatorMapper;

	@Override
	public CreatedTranslatorResponse handle(CreateTranslatorCommand command) {
		Translator translator = createTranslatorMapper.toDomain(command);
		translator = translatorRepository.save(translator);
		return createTranslatorMapper.toResponse(translator);
	}

}
