package com.api.perfectchef.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedIngredientDto {
    private String original;
    private String image;
    private double amount;
    private String unit;
}