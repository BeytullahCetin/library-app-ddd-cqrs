package com.turkcell.library_app_ddd_cqrs.persistence.borrow;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBorrowRepository extends JpaRepository<JpaBorrowEntity, UUID> {
	List<JpaBorrowEntity> findByCustomerId(UUID customerId);
}

