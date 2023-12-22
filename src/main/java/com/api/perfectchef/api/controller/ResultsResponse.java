package com.api.perfectchef.api.controller;

import com.api.perfectchef.api.apimodel.Recipe;
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
