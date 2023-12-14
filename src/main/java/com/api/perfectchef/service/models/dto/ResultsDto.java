package com.api.perfectchef.service.models.dto;

import com.api.perfectchef.service.models.apimodel.Recipe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultsDto {
    private List<Recipe> recipes;
}
