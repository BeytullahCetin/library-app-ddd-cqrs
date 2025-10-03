package com.turkcell.library_app_ddd_cqrs.domain.customer.model;

import java.time.LocalDate;

public class Customer {
	private final CustomerId id;
	private String name;
	private String email;
	private String phone;
	private LocalDate registerDate;

	private Customer(CustomerId id, String name, String email, String phone, LocalDate registerDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.registerDate = registerDate;
	}

	public static Customer create(String name, String email, String phone, LocalDate registerDate) {
		validateName(name);
		validateEmail(email);
		validatePhone(phone);
		validateRegisterDate(registerDate);

		return new Customer(CustomerId.generate(), name, email, phone, registerDate);
	}

	public static Customer rehydrate(CustomerId id, String name, String email, String phone,
			LocalDate registerDate) {
		return new Customer(id, name, email, phone, registerDate);
	}

	private static void validateName(String name) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("Name cannot be null or empty!");

		if (name.length() >= 255)
			throw new IllegalArgumentException("Name length must be less than 255 characters!");
	}

	private static void validateEmail(String email) {
		if (email == null || email.isEmpty())
			throw new IllegalArgumentException("Email cannot be null or empty!");

		if (email.length() >= 255)
			throw new IllegalArgumentException("Email length must be less than 255 characters!");

		// TODO: Email format validation with regex
	}

	private static void validatePhone(String phone) {
		if (phone == null || phone.isEmpty())
			throw new IllegalArgumentException("Phone cannot be null or empty!");

		if (phone.length() >= 255)
			throw new IllegalArgumentException("Phone length must be less than 255 characters!");

		// TODO: Phone format validation with regex
	}

	private static void validateRegisterDate(LocalDate registerDate) {
		if (registerDate == null)
			throw new IllegalArgumentException("Register date cannot be null!");
	}

	public void rename(String name) {
		this.name = name;
	}

	public void changeEmail(String email) {
		this.email = email;
	}

	public void changePhone(String phone) {
		this.phone = phone;
	}

	public CustomerId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}
}
