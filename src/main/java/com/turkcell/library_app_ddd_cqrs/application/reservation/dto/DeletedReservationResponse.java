package com.turkcell.library_app_ddd_cqrs.application.reservation.dto;

import java.time.LocalDate;
import java.util.UUID;

public record DeletedReservationResponse(
		UUID id,
		int boookId,
		LocalDate expireAt,
		String status) {

}
