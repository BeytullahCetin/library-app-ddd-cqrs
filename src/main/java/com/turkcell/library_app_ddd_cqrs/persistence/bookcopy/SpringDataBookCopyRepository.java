package com.turkcell.library_app_ddd_cqrs.persistence.bookcopy;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBookCopyRepository extends JpaRepository<JpaBookCopyEntity, UUID> {

}

