package com.devsu.hackerearth.backend.account.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartialAccountDto {
    private String type;
    private Double initialAmount;
    private Boolean isActive;
}
