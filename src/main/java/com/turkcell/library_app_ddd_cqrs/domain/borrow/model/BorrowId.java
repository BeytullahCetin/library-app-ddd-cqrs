package com.turkcell.library_app_ddd_cqrs.domain.borrow.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record BorrowId(UUID value) implements Serializable {

	public BorrowId {
		Objects.requireNonNull(value, "Value for BorrowId cannot be null!");
	}

	public static BorrowId generate() {
		return new BorrowId(UUID.randomUUID());
	}
}

