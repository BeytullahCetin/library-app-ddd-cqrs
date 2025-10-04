package com.turkcell.library_app_ddd_cqrs.application.fine.query;

import com.turkcell.library_app_ddd_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_app_ddd_cqrs.application.fine.mapper.FineResponseMapper;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_app_ddd_cqrs.domain.fine.repository.FineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListFinesPagedQueryHandler implements QueryHandler<ListFinesPagedQuery, List<FineResponse>> {
    private final FineRepository fineRepository;
    private final FineResponseMapper fineResponseMapper;

    @Override
    public List<FineResponse> handle(ListFinesPagedQuery query) {
        return fineRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(fineResponseMapper::toResponse)
                .toList();
    }

}
