package com.turkcell.library_app_ddd_cqrs.application.translator.mapper;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.DeletedTranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;

public class DeleteTranslatorMapper {
	public DeletedTranslatorResponse toResponse(Translator domain) {
		return new DeletedTranslatorResponse(domain.getId().value(), domain.getName());
	}
}
