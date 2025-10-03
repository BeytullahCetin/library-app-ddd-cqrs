package com.turkcell.library_app_ddd_cqrs.persistence.translator;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.turkcell.library_app_ddd_cqrs.domain.translator.model.Translator;
import com.turkcell.library_app_ddd_cqrs.domain.translator.model.TranslatorId;
import com.turkcell.library_app_ddd_cqrs.domain.translator.repository.TranslatorRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TranslatorRepositoryAdapter implements TranslatorRepository {

	private final SpringDataTranslatorRepository repository;
	private final TranslatorEntityMapper translatorEntityMapper;

	@Override
	public Optional<Translator> findById(TranslatorId id) {
		return repository
				.findById(id.value())
				.map(translatorEntityMapper::toDomain);

	}

	@Override
	public List<Translator> findAll() {
		return repository
				.findAll()
				.stream()
				.map(translatorEntityMapper::toDomain)
				.toList();
	}

	@Override
	public List<Translator> findAllPaged(Integer pageIndex, Integer pageSize) {
		return repository
				.findAll(PageRequest.of(pageIndex, pageSize))
				.stream()
				.map(translatorEntityMapper::toDomain)
				.toList();
	}

	@Override
	public Translator save(Translator translator) {
		JpaTranslatorEntity entity = translatorEntityMapper.toEntity(translator);
		entity = repository.save(entity);
		return translatorEntityMapper.toDomain(entity);
	}

	@Override
	public void delete(TranslatorId id) {
		repository.deleteById(id.value());
	}

}
