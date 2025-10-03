package com.turkcell.library_app_ddd_cqrs.domain.reservation.model;

import java.time.LocalDate;

import com.turkcell.library_app_ddd_cqrs.domain.customer.model.Customer;
import com.turkcell.library_app_ddd_cqrs.domain.customer.model.CustomerId;

public class Reservation {

	private final ReservationId id;
	private final CustomerId customerId;
	// TODO: Change int bookId to BookId bookId
	private int bookId;
	private LocalDate expireAt;
	private String status;

	private Reservation(ReservationId id, CustomerId customerId, int bookId, LocalDate expireAt, String status) {
		this.id = id;
		this.customerId = customerId;
		this.bookId = bookId;
		this.expireAt = expireAt;
		this.status = status;
	}

	public static Reservation create(Customer customer, int bookId, LocalDate expireAt, String status) {
		validateExpireAt(expireAt);
		validateStutus(status);

		return new Reservation(ReservationId.generate(), customer.getId(), bookId, expireAt, status);
	}

	public static Reservation rehydrate(ReservationId id, CustomerId customerId, int bookId, LocalDate expireAt,
			String status) {
		return new Reservation(id, customerId, bookId, expireAt, status);
	}

	public static void validateExpireAt(LocalDate date) {
		if (date == null)
			throw new IllegalArgumentException("Expire at cannot be null!");
	}

	public static void validateStutus(String status) {
		if (status == null || status.isEmpty())
			throw new IllegalArgumentException("Status cannot be null or empty");
	}

	public ReservationId getId() {
		return id;
	}

	public CustomerId getCustomerId() {
		return customerId;
	}

	public int getBookId() {
		return bookId;
	}

	public LocalDate getExpireAt() {
		return expireAt;
	}

	public String getStatus() {
		return status;
	}

}
