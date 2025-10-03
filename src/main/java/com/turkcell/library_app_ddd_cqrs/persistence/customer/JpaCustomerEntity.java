package com.turkcell.library_app_ddd_cqrs.persistence.customer;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class JpaCustomerEntity {
	@Id
	private UUID id;
	private String name;
	private String phone;
	private String email;
	private LocalDate registerDate;
}