package com.api.perfectchef.controller.model;

import com.api.perfectchef.service.models.apimodel.Recipe;
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
