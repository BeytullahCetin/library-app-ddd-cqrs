package com.turkcell.library_app_ddd_cqrs.persistence.translator;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.TranslatorId;

@Component
public class TranslatorEntityMapper {

	public JpaTranslatorEntity toEntity(Translator domain) {
		JpaTranslatorEntity entity = new JpaTranslatorEntity();
		entity.setId(domain.getId().value());
		entity.setName(domain.getName());

		return entity;
	}

	public Translator toDomain(JpaTranslatorEntity entity) {
		return Translator.rehydrate(new TranslatorId(entity.getId()), entity.getName());
	}
}