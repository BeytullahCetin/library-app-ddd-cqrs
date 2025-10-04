package com.turkcell.library_app_ddd_cqrs.application.fine.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_app_ddd_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_app_ddd_cqrs.domain.fine.model.Fine;

@Component
public class FineResponseMapper {
    public FineResponse toResponse(Fine domain) {
        return new FineResponse(
                domain.getId().value(),
                domain.getAmount(),
                domain.getDate(),
                domain.getFineType());
    }
}
