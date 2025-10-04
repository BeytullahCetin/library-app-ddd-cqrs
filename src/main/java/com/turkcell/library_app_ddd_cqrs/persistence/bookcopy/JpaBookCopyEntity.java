package com.turkcell.library_app_ddd_cqrs.persistence.bookcopy;

import java.time.LocalDateTime;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.core.enums.BookStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book_copies")
@Getter
@Setter
public class JpaBookCopyEntity {
	@Id
	private UUID id;
	private LocalDateTime acquisitionDate;

	@Enumerated(EnumType.STRING)
	private BookStatus bookStatus;

	private UUID bookId;
}

