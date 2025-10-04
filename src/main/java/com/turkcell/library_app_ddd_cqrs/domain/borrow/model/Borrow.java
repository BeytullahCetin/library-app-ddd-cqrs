package com.turkcell.library_app_ddd_cqrs.domain.borrow.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Borrow {
	private final BorrowId id;
	private LocalDateTime borrowDate;
	private LocalDateTime dueDate;
	private LocalDateTime returnDate;
	private UUID customerId;
	private UUID bookCopyId;

	private Borrow(BorrowId id, LocalDateTime borrowDate, LocalDateTime dueDate, LocalDateTime returnDate,
			UUID customerId, UUID bookCopyId) {
		this.id = id;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.customerId = customerId;
		this.bookCopyId = bookCopyId;
	}

	public static Borrow create(LocalDateTime borrowDate, LocalDateTime dueDate, LocalDateTime returnDate,
			UUID customerId, UUID bookCopyId) {
		validateBorrowDate(borrowDate);
		validateDueDate(dueDate);
		validateCustomerId(customerId);
		validateBookCopyId(bookCopyId);
		return new Borrow(BorrowId.generate(), borrowDate, dueDate, returnDate, customerId, bookCopyId);
	}

	public static Borrow rehydrate(BorrowId id, LocalDateTime borrowDate, LocalDateTime dueDate,
			LocalDateTime returnDate, UUID customerId, UUID bookCopyId) {
		return new Borrow(id, borrowDate, dueDate, returnDate, customerId, bookCopyId);
	}

	private static void validateBorrowDate(LocalDateTime borrowDate) {
		if (borrowDate == null)
			throw new IllegalArgumentException("Borrow date cannot be null");
	}

	private static void validateDueDate(LocalDateTime dueDate) {
		if (dueDate == null)
			throw new IllegalArgumentException("Due date cannot be null");
	}

	private static void validateCustomerId(UUID customerId) {
		if (customerId == null)
			throw new IllegalArgumentException("Customer ID cannot be null");
	}

	private static void validateBookCopyId(UUID bookCopyId) {
		if (bookCopyId == null)
			throw new IllegalArgumentException("BookCopy ID cannot be null");
	}

	public BorrowId getId() {
		return id;
	}

	public LocalDateTime getBorrowDate() {
		return borrowDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public UUID getBookCopyId() {
		return bookCopyId;
	}

	public void returnBook(LocalDateTime returnDate) {
		if (returnDate == null)
			throw new IllegalArgumentException("Return date cannot be null");
		this.returnDate = returnDate;
	}

	public void updateBorrowDate(LocalDateTime borrowDate) {
		validateBorrowDate(borrowDate);
		this.borrowDate = borrowDate;
	}

	public void updateDueDate(LocalDateTime dueDate) {
		validateDueDate(dueDate);
		this.dueDate = dueDate;
	}
}

