package com.turkcell.library_app_ddd_cqrs.application.fine.query;


import com.turkcell.library_app_ddd_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record FindByIdFineQuery(@NotBlank UUID id) implements Query<FineResponse> {
}
