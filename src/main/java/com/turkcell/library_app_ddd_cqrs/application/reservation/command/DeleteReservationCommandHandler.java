package com.turkcell.library_app_ddd_cqrs.application.reservation.command;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.DeletedReservationResponse;
import com.turkcell.library_app_ddd_cqrs.application.reservation.mapper.DeleteReservationMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.ReservationId;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteReservationCommandHandler
		implements CommandHandler<DeleteReservationCommand, DeletedReservationResponse> {

	private final ReservationRepository reservationRepository;
	private final DeleteReservationMapper deleteReservationMapper;

	@Override
	public DeletedReservationResponse handle(DeleteReservationCommand command) {
		Optional<Reservation> reservation = reservationRepository.findById(new ReservationId(command.id()));

		if (reservation == null)
			throw new IllegalArgumentException("Bu id ile bir reservation bulunamadı!");

		reservationRepository.delete(reservation.get().getId());
		return deleteReservationMapper.toResponse(reservation.get());
	}
}
