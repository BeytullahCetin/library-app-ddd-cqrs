package com.turkcell.library_app_ddd_cqrs.persistence.translator;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTranslatorRepository extends JpaRepository<JpaTranslatorEntity, UUID> {

}
