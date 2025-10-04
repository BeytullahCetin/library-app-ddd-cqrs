package com.turkcell.library_app_ddd_cqrs.application.fine.dto;

import java.time.LocalDate;
import java.util.UUID;

public record FineResponse(UUID id, Float amount,LocalDate date,FineResponse fineResponse) {
}
