package com.turkcell.library_app_ddd_cqrs.application.translator.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.TranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.application.translator.mapper.TranslatorResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.translator.repository.TranslatorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListTranslatorsPagedQueryHandler
		implements QueryHandler<ListTranslatorsPagedQuery, List<TranslatorResponse>> {

	private final TranslatorRepository translatorRepository;
	private final TranslatorResponseMapper translatorResponseMapper;

	@Override
	public List<TranslatorResponse> handle(ListTranslatorsPagedQuery query) {
		return translatorRepository
				.findAllPaged(query.pageIndex(), query.pageSize())
				.stream()
				.map(translatorResponseMapper::toResponse)
				.toList();
	}

}
