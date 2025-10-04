package com.turkcell.library_app_ddd_cqrs.interfaces.web;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app_ddd_cqrs.application.reservation.command.CreateReservationCommand;
import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.library_app_ddd_cqrs.application.reservation.dto.ReservationResponse;
import com.turkcell.library_app_ddd_cqrs.application.reservation.query.FindByIdReservationQuery;
import com.turkcell.library_app_ddd_cqrs.application.reservation.query.ListReservationPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class ReservationController {
	private final QueryHandler<ListReservationPagedQuery, List<ReservationResponse>> listReservationQueryHandler;
	private final QueryHandler<FindByIdReservationQuery, ReservationResponse> findByIdReservationQueryHandler;
	private final CommandHandler<CreateReservationCommand, CreatedReservationResponse> createReservatiCommandHandler;

	@GetMapping("/v1/resevations")
	public List<ReservationResponse> getAuthorsPaged(@Valid ListReservationPagedQuery query) {
		return listReservationQueryHandler.handle(query);
	}

	@GetMapping("/v1/reservations/{id}")
	public ReservationResponse getAuthorsPaged(@Valid FindByIdReservationQuery query) {
		return findByIdReservationQueryHandler.handle(query);
	}

	@PostMapping("/v1/resevations")
	public CreatedReservationResponse createAuthor(@RequestBody CreateReservationCommand command) {
		return createReservatiCommandHandler.handle(command);
	}
}
