package com.turkcell.library_app_ddd_cqrs.domain.translator.model;

public class Translator {
	private final TranslatorId id;
	private String name;

	private Translator(TranslatorId id, String name) {
		this.id = id;
		this.name = name;
	}

	public static Translator create(String name) {
		validateName(name);
		return new Translator(TranslatorId.generate(), name);
	}

	public static Translator rehydrate(TranslatorId id, String name) {
		return new Translator(id, name);
	}

	private static void validateName(String name) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("Name cannot be null or empty");

		if (name.length() >= 255)
			throw new IllegalArgumentException("Name length must be less than 255 characters");
	}

	public TranslatorId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void rename(String name) {
		validateName(name);
		this.name = name;
	}
}
