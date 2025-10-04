package com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record BookCopyId(UUID value) implements Serializable {

	public BookCopyId {
		Objects.requireNonNull(value, "Value for BookCopyId cannot be null!");
	}

	public static BookCopyId generate() {
		return new BookCopyId(UUID.randomUUID());
	}
}

