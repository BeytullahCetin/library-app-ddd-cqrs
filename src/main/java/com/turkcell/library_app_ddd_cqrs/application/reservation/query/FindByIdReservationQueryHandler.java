package com.turkcell.library_app_ddd_cqrs.application.reservation.query;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.ReservationResponse;
import com.turkcell.library_app_ddd_cqrs.application.reservation.mapper.ReservationResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.ReservationId;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdReservationQueryHandler implements QueryHandler<FindByIdReservationQuery, ReservationResponse> {

	private final ReservationRepository reservationRepository;
	private final ReservationResponseMapper reservationResponseMapper;

	@Override
	public ReservationResponse handle(FindByIdReservationQuery query) {
		return reservationResponseMapper
				.toResponse(reservationRepository.findById(new ReservationId(query.id())).get());
	}

}
