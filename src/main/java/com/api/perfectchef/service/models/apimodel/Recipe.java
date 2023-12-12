package com.api.perfectchef.service.models.apimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "recipes")
public class Recipe {
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private boolean veryHealthy;
    private boolean cheap;
    private boolean veryPopular;
    private boolean sustainable;
    @JsonIgnoreProperties
    private boolean lowFodmap;
    @JsonIgnoreProperties
    private int weightWatcherSmartPoints;
    private String gaps;
    private int preparationMinutes;
    private int cookingMinutes;
    @JsonIgnoreProperties
    private int aggregateLikes;
    private int healthScore;
    @JsonIgnoreProperties
    private String creditsText;
    private String license;
    private String sourceName;
    private double pricePerServing;
    private List<ExtendedIngredient> extendedIngredients;
    private int id;
    private String title;
    private int readyInMinutes;
    private int servings;
    private String sourceUrl;
    private String image;
    private String imageType;
    private String summary;
    private List<String> cuisines;
    private List<String> dishTypes;
    private List<String> diets;
    private List<String> occasions;
    private String instructions;
    private List<AnalyzedInstruction> analyzedInstructions;
    private String originalId;
    @JsonIgnoreProperties
    private double spoonacularScore;
    private String spoonacularSourceUrl;
}