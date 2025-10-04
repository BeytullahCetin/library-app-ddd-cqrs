package com.turkcell.library_app_ddd_cqrs.application.reservation.query;

import java.util.List;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.ReservationResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.Min;

public record ListReservationPagedQuery(
		@Min(0) Integer pageIndex,
		@Min(1) Integer pageSize)
		implements Query<List<ReservationResponse>> {
}
