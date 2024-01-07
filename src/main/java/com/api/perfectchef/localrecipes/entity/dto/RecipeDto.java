package com.api.perfectchef.localrecipes.entity.dto;

import com.api.perfectchef.api.model.AnalyzedInstructionDto;
import com.api.perfectchef.api.model.ExtendedIngredientDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private String image;
    private String title;
    private List<String> dishTypes;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private int cookingMinutes;
    private int preparationMinutes;
    private int servings;
    private double pricePerServing;
    private String summary;
    private List<ExtendedIngredientDto> extendedIngredients;
    private List<AnalyzedInstructionDto> analyzedInstructions;
    private String sourceName;
    private String sourceUrl;
}
