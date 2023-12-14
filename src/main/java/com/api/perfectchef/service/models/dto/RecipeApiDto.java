package com.api.perfectchef.service.models.dto;

import com.api.perfectchef.service.models.apimodel.AnalyzedInstruction;
import com.api.perfectchef.service.models.apimodel.ExtendedIngredient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
public class RecipeApiDto {
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private int preparationMinutes;
    private int healthScore;
    private String sourceName;
    private double pricePerServing;
    private List<ExtendedIngredient> extendedIngredients;
    private String title;
    private int servings;
    private String sourceUrl;
    private String image;
    private String summary;
    private List<String> cuisines;
    private List<String> dishTypes;
    private List<String> occasions;
    private List<AnalyzedInstruction> analyzedInstructions;
    private String originalId;
}
