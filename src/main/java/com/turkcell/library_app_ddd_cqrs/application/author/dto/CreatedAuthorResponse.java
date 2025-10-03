package com.turkcell.library_app_ddd_cqrs.application.author.dto;

import java.util.UUID;

public record CreatedAuthorResponse(UUID id, String name) {
}
