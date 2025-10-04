package com.turkcell.library_app_ddd_cqrs.application.reservation.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.ReservationResponse;
import com.turkcell.library_app_ddd_cqrs.application.reservation.mapper.ReservationResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListReservationPagedQueryHandler
		implements QueryHandler<ListReservationPagedQuery, List<ReservationResponse>> {

	private final ReservationRepository reservationRepository;
	private final ReservationResponseMapper reservationResponseMapper;

	@Override
	public List<ReservationResponse> handle(ListReservationPagedQuery query) {
		return reservationRepository
				.findAllPaged(query.pageIndex(), query.pageSize())
				.stream()
				.map(reservationResponseMapper::toResponse)
				.toList();
	}

}
