package com.api.perfectchef.controller.model;

import com.api.perfectchef.service.models.model.Recipe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsResponse {
   private List<Recipe> recipes;

}
