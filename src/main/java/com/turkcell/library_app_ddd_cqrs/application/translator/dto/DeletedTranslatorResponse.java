package com.turkcell.library_app_ddd_cqrs.application.translator.dto;

import java.util.UUID;

public record DeletedTranslatorResponse(UUID id, String name) {

}
