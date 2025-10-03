package com.turkcell.library_app_ddd_cqrs.domain.reservation.repository;

import java.util.List;
import java.util.Optional;

import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.ReservationId;

public interface ReservationRepository {
	Optional<Reservation> findById(ReservationId id);

	List<Reservation> findAll();

	List<Reservation> findAllPaged(Integer pageIndex, Integer pageSize);

	Reservation save(Reservation reservation);

	void delete(ReservationId id);
}
