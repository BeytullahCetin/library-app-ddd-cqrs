package com.turkcell.library_app_ddd_cqrs.persistence.publisher;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "publishers")
@Getter
@Setter
public class JpaPublisherEntity {
	@Id
	private UUID id;
	private String name;
	private String address;
}

