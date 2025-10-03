package com.turkcell.library_app_ddd_cqrs.domain.translator.repository;

import java.util.List;
import java.util.Optional;

import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.TranslatorId;

public interface TranslatorRepository {
	Optional<Translator> findById(TranslatorId id);

	List<Translator> findAllPaged(Integer pageIndex, Integer pageSize);

	Translator save(Translator translator);

	void delete(TranslatorId id);
}
