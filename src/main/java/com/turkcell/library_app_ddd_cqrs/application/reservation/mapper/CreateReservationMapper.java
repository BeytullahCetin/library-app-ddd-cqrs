package com.turkcell.library_app_ddd_cqrs.application.reservation.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.reservation.command.CreateReservationCommand;
import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;

@Component
public class CreateReservationMapper {
	public Reservation toDomain(CreateReservationCommand command) {
		return Reservation.create(new CustomerId(command.customerId()), command.boookId(), command.expireAt(),
				command.status());
	}

	public CreatedReservationResponse toResponse(Reservation domain) {
		return new CreatedReservationResponse(
				domain.getId().value(),
				domain.getBookId(),
				domain.getExpireAt(),
				domain.getStatus());
	}
}
