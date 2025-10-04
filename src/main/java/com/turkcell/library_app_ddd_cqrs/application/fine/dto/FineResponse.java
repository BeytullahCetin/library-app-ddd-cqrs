package com.turkcell.library_app_ddd_cqrs.application.fine.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.turkcell.library_app_ddd_cqrs.domain.fine.enums.FineType;

public record FineResponse(UUID id, Float amount, LocalDate date, FineType fineType) {
}
