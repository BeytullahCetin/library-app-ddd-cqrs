package com.turkcell.library_app_ddd_cqrs.persistence.fine;

import com.turkcell.library_app_ddd_cqrs.domain.fine.enums.FineType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "fines")
public class JpaFineEntity {
    @Id
    private UUID id;
    private float amount;
    private LocalDate date;
    private FineType fineType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FineType getFineType() {
        return fineType;
    }

    public void setFineType(FineType fineType) {
        this.fineType = fineType;
    }
}
