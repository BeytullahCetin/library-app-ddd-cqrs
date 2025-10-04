package com.turkcell.library_app_ddd_cqrs.interfaces.web;


import com.turkcell.library_app_ddd_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_app_ddd_cqrs.application.fine.query.FindByIdFineQuery;
import com.turkcell.library_app_ddd_cqrs.application.fine.query.ListFinesPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class FineController {
    private final QueryHandler<ListFinesPagedQuery, List<FineResponse>> listFineQueryHandler;
    private final QueryHandler<FindByIdFineQuery, FineResponse> findByIdFineQueryHandler;


    public FineController(QueryHandler<ListFinesPagedQuery, List<FineResponse>> listFineQueryHandler,
                          QueryHandler<FindByIdFineQuery, FineResponse> findByIdFineQueryHandler
    ) {
        this.listFineQueryHandler = listFineQueryHandler;
        this.findByIdFineQueryHandler = findByIdFineQueryHandler;

    }

    @GetMapping("/v1/fines")
    public List<FineResponse> getFinesPaged(@Valid ListFinesPagedQuery query) {
        return listFineQueryHandler.handle(query);
    }

    @GetMapping("/v1/fines")
    public FineResponse getFinesPaged(@Valid FindByIdFineQuery query) {
        return findByIdFineQueryHandler.handle(query);
    }
}

