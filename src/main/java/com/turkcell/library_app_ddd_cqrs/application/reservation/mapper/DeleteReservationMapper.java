package com.turkcell.library_app_ddd_cqrs.application.reservation.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.DeletedReservationResponse;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;

@Component
public class DeleteReservationMapper {
	public DeletedReservationResponse toResponse(Reservation domain) {
		return new DeletedReservationResponse(domain.getId().value(), domain.getBookId(), domain.getExpireAt(),
				domain.getStatus());
	}
}
