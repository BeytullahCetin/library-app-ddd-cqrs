package com.turkcell.library_app_ddd_cqrs.persistence.language;

import com.turkcell.library_app_ddd_cqrs.domain.language.model.Language;
import com.turkcell.library_app_ddd_cqrs.domain.language.model.LanguageId;
import org.springframework.stereotype.Component;

@Component
public class LanguageEntityMapper {
    public JpaLanguageEntity toEntity(Language domain) {
        JpaLanguageEntity entity = new JpaLanguageEntity();
        entity.setId(domain.getId().value());
        entity.setName(domain.getName());
        return entity;
    }

    public Language toDomain(JpaLanguageEntity entity) {
        return Language.rehydrate(new LanguageId(entity.getId()),
                entity.getName());
    }
}
