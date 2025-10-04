package com.turkcell.library_app_ddd_cqrs.persistence.fine;


import com.turkcell.library_app_ddd_cqrs.domain.fine.model.Fine;
import com.turkcell.library_app_ddd_cqrs.domain.fine.model.FineId;
import org.springframework.stereotype.Component;

@Component
public class FineEntityMapper {
    public JpaFineEntity toEntity(Fine domain) {
        JpaFineEntity entity = new JpaFineEntity();
        entity.setId(domain.getId().value());
        entity.setAmount(domain.getAmount());
        entity.setDate(domain.getDate());
        entity.setFineType(domain.getFineType());
        return entity;
    }

    public Fine toDomain(JpaFineEntity entity) {
        return Fine.rehydrate(new FineId(entity.getId()),
                entity.getAmount(),
                entity.getDate(),
                entity.getFineType());

    }
}
