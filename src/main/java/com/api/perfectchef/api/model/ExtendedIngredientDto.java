package com.api.perfectchef.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "extendedIngredients")
public class ExtendedIngredientDto {
    private String original;
    private String image;
    private double amount;
    private String unit;
//    private MeasuresDto measures;
}