package com.api.perfectchef.service.models.dto;

import com.api.perfectchef.service.models.Type;
import com.api.perfectchef.service.models.dto.api.AnalyzedInstructionDto;
import com.api.perfectchef.service.models.dto.api.ExtendedIngredientDto;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
public class LocalRecipeDto {
    private ObjectId _id;
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