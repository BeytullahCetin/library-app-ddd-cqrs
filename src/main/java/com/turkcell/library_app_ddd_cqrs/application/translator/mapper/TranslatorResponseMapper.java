package com.turkcell.library_app_ddd_cqrs.application.translator.mapper;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.TranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;

public class TranslatorResponseMapper {
	public TranslatorResponse toResponse(Translator domain) {
		return new TranslatorResponse(domain.getId().value(), domain.getName());
	}
}
