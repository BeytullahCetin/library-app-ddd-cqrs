package com.turkcell.library_app_ddd_cqrs.persistence.author;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class JpaAuthorEntity {
	@Id
	private UUID id;
	private String name;
}
