package com.turkcell.library_app_ddd_cqrs.application.reservation.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.ReservationResponse;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;

@Component
public class ReservationResponseMapper {
	public ReservationResponse toResponse(Reservation domain) {
		return new ReservationResponse(domain.getId().value(), domain.getBookId(), domain.getExpireAt(),
				domain.getStatus());
	}
}
