package com.turkcell.library_app_ddd_cqrs.persistence.author;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAuthorRepository extends JpaRepository<JpaAuthorEntity, UUID> {

}
