package com.turkcell.library_app_ddd_cqrs.application.reservation.command;

import java.time.LocalDate;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotBlank;

public record CreateReservationCommand(
		@NotBlank UUID customerId,
		@NotBlank int boookId,
		@NotBlank LocalDate expireAt,
		@NotBlank String status)
		implements Command<CreatedReservationResponse> {
}
