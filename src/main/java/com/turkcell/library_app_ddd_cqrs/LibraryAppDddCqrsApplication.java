package com.turkcell.library_app_ddd_cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryAppDddCqrsApplication {

	// Alişan - Book - Language - Fine
	// Arda - Borrow - Publisher - Bookcopy
	// Beytullah - Customer - Translator - Author - Reservation

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppDddCqrsApplication.class, args);
	}

}
