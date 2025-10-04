package com.turkcell.library_app_ddd_cqrs.persistence.borrow;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "borrows")
@Getter
@Setter
public class JpaBorrowEntity {
	@Id
	private UUID id;
	private LocalDateTime borrowDate;
	private LocalDateTime dueDate;
	private LocalDateTime returnDate;
	private UUID customerId;
	private UUID bookCopyId;
}

