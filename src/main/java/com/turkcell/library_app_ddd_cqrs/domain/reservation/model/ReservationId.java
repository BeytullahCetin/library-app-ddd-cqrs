package com.turkcell.library_app_ddd_cqrs.domain.reservation.model;

import java.util.Objects;
import java.util.UUID;

public record ReservationId(UUID value) {
	public ReservationId {
		Objects.requireNonNull(value, "Value for ReservationId cannot be null!");
	}

	public static ReservationId generate() {
		return new ReservationId(UUID.randomUUID());
	}
}
