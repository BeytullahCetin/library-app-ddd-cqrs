package com.turkcell.library_app_ddd_cqrs.application.publisher.dto;

import java.util.UUID;

public record CreatedPublisherResponse(UUID id, String name, String address) {
}

