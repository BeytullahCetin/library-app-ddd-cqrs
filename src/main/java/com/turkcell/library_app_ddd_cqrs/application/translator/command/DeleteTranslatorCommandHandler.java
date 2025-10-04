package com.turkcell.library_app_ddd_cqrs.application.translator.command;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.DeletedTranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.application.translator.mapper.DeleteTranslatorMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.TranslatorId;
import com.turkcell.library_app_ddd_cqrs.domain.translator.repository.TranslatorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteTranslatorCommandHandler
		implements CommandHandler<DeleteTranslatorCommand, DeletedTranslatorResponse> {

	private final TranslatorRepository translatorRepository;
	private final DeleteTranslatorMapper deleteTranslatorMapper;

	@Override
	public DeletedTranslatorResponse handle(DeleteTranslatorCommand command) {
		Optional<Translator> translator = translatorRepository.findById(new TranslatorId(command.id()));

		if (translator == null) {
			throw new IllegalArgumentException("Bu id ile bir translator bulunamadı!");
		}

		translatorRepository.delete(translator.get().getId());
		return deleteTranslatorMapper.toResponse(translator.get());
	}

}
