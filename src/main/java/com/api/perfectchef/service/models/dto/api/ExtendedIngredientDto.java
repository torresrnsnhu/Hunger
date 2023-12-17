package com.api.perfectchef.service.models.dto.api;

import com.api.perfectchef.service.models.apimodel.Measures;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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