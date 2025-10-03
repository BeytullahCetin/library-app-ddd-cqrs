package com.turkcell.library_app_ddd_cqrs.persistence.reservation;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.ReservationId;

@Component
public class ReservationEntityMapper {
	public JpaReservationEntity toEntity(Reservation domain) {
		JpaReservationEntity entity = new JpaReservationEntity();
		entity.setId(domain.getId().value());
		entity.setCustomerId(domain.getCustomerId().value());
		entity.setBookId(domain.getBookId());
		entity.setExpireAt(domain.getExpireAt());
		entity.setStatus(domain.getStatus());

		return entity;
	}

	public Reservation toDomain(JpaReservationEntity entity) {
		return Reservation.rehydrate(
				new ReservationId(entity.getId()),
				new CustomerId(entity.getCustomerId()),
				entity.getBookId(),
				entity.getExpireAt(),
				entity.getStatus());
	}
}
