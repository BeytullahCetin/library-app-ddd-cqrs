package com.turkcell.library_app_ddd_cqrs.application.translator.query;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.TranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.application.translator.mapper.TranslatorResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.TranslatorId;
import com.turkcell.library_app_ddd_cqrs.domain.translator.repository.TranslatorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdTranslatorQueryHandler implements QueryHandler<FindByIdTranslatorQuery, TranslatorResponse> {

	private final TranslatorRepository translatorRepository;
	private final TranslatorResponseMapper translatorResponseMapper;

	@Override
	public TranslatorResponse handle(FindByIdTranslatorQuery query) {
		return translatorResponseMapper.toResponse(translatorRepository.findById(new TranslatorId(query.id())).get());
	}

}
