package com.turkcell.library_app_ddd_cqrs.application.translator.query;

import java.util.List;

import com.turkcell.library_app_ddd_cqrs.application.translator.dto.TranslatorResponse;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.Query;

import jakarta.validation.constraints.Min;

public record ListTranslatorsPagedQuery(
		@Min(0) Integer pageIndex,
		@Min(1) Integer pageSize) implements Query<List<TranslatorResponse>> {
}
