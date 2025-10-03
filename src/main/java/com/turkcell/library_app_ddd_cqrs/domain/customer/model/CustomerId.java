package com.turkcell.library_app_ddd_cqrs.domain.customer.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record CustomerId(UUID value) implements Serializable {
	public CustomerId {
		Objects.requireNonNull(value, "Value for CustomerId cannot be null!");
	}

	public static CustomerId generate() {
		return new CustomerId(UUID.randomUUID());
	}
}
