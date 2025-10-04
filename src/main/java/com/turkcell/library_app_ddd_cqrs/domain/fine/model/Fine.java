package com.turkcell.library_app_ddd_cqrs.domain.fine.model;

import com.turkcell.library_app_ddd_cqrs.domain.fine.enums.FineType;

import java.time.LocalDate;

public class Fine {
    private final FineId id;
    private float amount;
    private LocalDate date;
    private FineType fineType;

    private Fine(FineId id,float amount,LocalDate date,FineType fineType){
        this.id=id;
        this.amount=amount;
        this.date=date;
        this.fineType=fineType;


    }

    public static Fine create(float amount,LocalDate date,FineType fineType){
        validateDate(date);
        validateAmount(amount);
        return new Fine(FineId.generate(),amount,date,fineType);
    }

    public static Fine rehydrate(FineId id,float amount,LocalDate date,FineType fineType) {
        return new Fine(id, amount,date,fineType);
    }

    private static void validateDate(LocalDate date) {
        if (date == null)
            throw new IllegalArgumentException("date cannot be null!");
    }

    public static void validateAmount(float amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero. Given: " + amount);
        }
    }

    public void changeFineType(FineType fineType){
        this.fineType=fineType;
    }

    public void changeAmount(float amount){
        validateAmount(amount);
        this.amount=amount;
    }

    public FineId getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public FineType getFineType() {
        return fineType;
    }
}
