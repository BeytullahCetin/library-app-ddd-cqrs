package com.turkcell.library_app_ddd_cqrs.interfaces.web;

import com.turkcell.library_app_ddd_cqrs.application.language.dto.LanguageResponse;
import com.turkcell.library_app_ddd_cqrs.application.language.query.FindByIdLanguageQuery;
import com.turkcell.library_app_ddd_cqrs.application.language.query.ListLanguagesPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class LanguageController {
    private final QueryHandler<ListLanguagesPagedQuery, List<LanguageResponse>> listLanguageQueryHandler;
    private final QueryHandler<FindByIdLanguageQuery, LanguageResponse> findByIdLanguageQueryHandler;

    public LanguageController(QueryHandler<ListLanguagesPagedQuery, List<LanguageResponse>> listLanguageQueryHandler,
            QueryHandler<FindByIdLanguageQuery, LanguageResponse> findByIdLanguageQueryHandler) {
        this.listLanguageQueryHandler = listLanguageQueryHandler;
        this.findByIdLanguageQueryHandler = findByIdLanguageQueryHandler;
    }

    @GetMapping("/v1/languages")
    public List<LanguageResponse> getLanguagesPaged(@Valid ListLanguagesPagedQuery query) {
        return listLanguageQueryHandler.handle(query);
    }

    @GetMapping("/v1/languages/{id}")
    public LanguageResponse getLanguagesPaged(@Valid FindByIdLanguageQuery query) {
        return findByIdLanguageQueryHandler.handle(query);
    }

}
