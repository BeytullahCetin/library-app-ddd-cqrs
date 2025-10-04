package com.turkcell.library_app_ddd_cqrs.application.reservation.query;

import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.ReservationResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.NotBlank;

public record FindByIdReservationQuery(@NotBlank UUID id) implements Query<ReservationResponse> {

}
