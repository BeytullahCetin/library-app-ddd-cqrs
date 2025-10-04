package com.turkcell.library_app_ddd_cqrs.persistence.publisher;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPublisherRepository extends JpaRepository<JpaPublisherEntity, UUID> {

}

