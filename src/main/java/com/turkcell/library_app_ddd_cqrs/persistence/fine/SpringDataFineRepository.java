package com.turkcell.library_app_ddd_cqrs.persistence.fine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataFineRepository extends JpaRepository<JpaFineEntity, UUID> {
}
