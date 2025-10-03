package com.turkcell.library_app_ddd_cqrs.persistence.translator;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "translators")
@Getter
@Setter
public class JpaTranslatorEntity {
	@Id
	private UUID id;
	private String name;
}
