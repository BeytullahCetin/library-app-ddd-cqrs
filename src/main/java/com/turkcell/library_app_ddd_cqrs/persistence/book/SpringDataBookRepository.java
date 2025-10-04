package com.turkcell.library_app_ddd_cqrs.persistence.book;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataBookRepository extends JpaRepository<JpaBookEntity, UUID> {
	
}
