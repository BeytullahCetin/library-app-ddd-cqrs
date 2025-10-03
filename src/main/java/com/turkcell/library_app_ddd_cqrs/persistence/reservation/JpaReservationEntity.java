package com.turkcell.library_app_ddd_cqrs.persistence.reservation;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class JpaReservationEntity {
	@Id
	private UUID id;
	private UUID customerId;
	private int bookId;
	private LocalDate expireAt;
	private String status;
}
