package com.turkcell.library_app_ddd_cqrs.application.reservation.command;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.library_app_ddd_cqrs.application.reservation.mapper.CreateReservationMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;

import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateReservationCommandHandler
		implements CommandHandler<CreateReservationCommand, CreatedReservationResponse> {
	private final ReservationRepository reservationRepository;
	private final CreateReservationMapper createReservationMapper;

	@Override
	public CreatedReservationResponse handle(CreateReservationCommand command) {
		Reservation reservation = createReservationMapper.toDomain(command);
		reservation = reservationRepository.save(reservation);
		return createReservationMapper.toResponse(reservation);
	}
}
