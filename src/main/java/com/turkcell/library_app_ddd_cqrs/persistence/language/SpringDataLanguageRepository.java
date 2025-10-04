package com.turkcell.library_app_ddd_cqrs.persistence.language;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataLanguageRepository extends JpaRepository<JpaLanguageEntity, UUID> {
}
