package com.devsu.hackerearth.backend.account.model.dto;

public class PartialAccountDto {
    private String type;
    private Double initialAmount;
    private Boolean isActive;

    public PartialAccountDto() {
    }

    public PartialAccountDto(String type, Double initialAmount, Boolean isActive) {
        this.type = type;
        this.initialAmount = initialAmount;
        this.isActive = isActive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
