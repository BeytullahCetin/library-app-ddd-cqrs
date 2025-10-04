package com.turkcell.library_app_ddd_cqrs.application.reservation.command;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.DeletedReservationResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Command;

import jakarta.validation.constraints.NotBlank;

public record DeleteReservationCommand(@NotBlank UUID id) implements Command<DeletedReservationResponse> {

}
