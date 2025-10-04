package com.turkcell.library_app_ddd_cqrs.domain.bookcopy.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.core.enums.BookStatus;

public class BookCopy {
	private final BookCopyId id;
	private LocalDateTime acquisitionDate;
	private BookStatus bookStatus;
	private UUID bookId;

	private BookCopy(BookCopyId id, LocalDateTime acquisitionDate, BookStatus bookStatus, UUID bookId) {
		this.id = id;
		this.acquisitionDate = acquisitionDate;
		this.bookStatus = bookStatus;
		this.bookId = bookId;
	}

	public static BookCopy create(LocalDateTime acquisitionDate, BookStatus bookStatus, UUID bookId) {
		validateAcquisitionDate(acquisitionDate);
		validateBookStatus(bookStatus);
		validateBookId(bookId);
		return new BookCopy(BookCopyId.generate(), acquisitionDate, bookStatus, bookId);
	}

	public static BookCopy rehydrate(BookCopyId id, LocalDateTime acquisitionDate, BookStatus bookStatus,
			UUID bookId) {
		return new BookCopy(id, acquisitionDate, bookStatus, bookId);
	}

	private static void validateAcquisitionDate(LocalDateTime acquisitionDate) {
		if (acquisitionDate == null)
			throw new IllegalArgumentException("Acquisition date cannot be null");

		if (acquisitionDate.isAfter(LocalDateTime.now()))
			throw new IllegalArgumentException("Acquisition date cannot be in the future");
	}

	private static void validateBookStatus(BookStatus bookStatus) {
		if (bookStatus == null)
			throw new IllegalArgumentException("Book status cannot be null");
	}

	private static void validateBookId(UUID bookId) {
		if (bookId == null)
			throw new IllegalArgumentException("Book ID cannot be null");
	}

	public BookCopyId getId() {
		return id;
	}

	public LocalDateTime getAcquisitionDate() {
		return acquisitionDate;
	}

	public BookStatus getBookStatus() {
		return bookStatus;
	}

	public UUID getBookId() {
		return bookId;
	}

	public void changeStatus(BookStatus bookStatus) {
		validateBookStatus(bookStatus);
		this.bookStatus = bookStatus;
	}

	public void changeAcquisitionDate(LocalDateTime acquisitionDate) {
		validateAcquisitionDate(acquisitionDate);
		this.acquisitionDate = acquisitionDate;
	}
}

