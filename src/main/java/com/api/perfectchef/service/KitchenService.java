package com.api.perfectchef.service;

import com.api.perfectchef.configuration.ApiConfig;
import com.api.perfectchef.controller.model.ResultsResponse;
import com.api.perfectchef.repositories.KitchenRepository;
import com.api.perfectchef.service.models.model.Recipe;
import com.api.perfectchef.service.models.model.Results;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;
@Service
public class KitchenService {
    private final KitchenRepository kitchenRepository;
    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;

    public KitchenService(RestTemplateBuilder restTemplateBuilder, KitchenRepository kitchenRepository, ApiConfig apiConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.kitchenRepository = kitchenRepository;
        this.apiConfig = apiConfig;
    }

    public String makeHttpGetRequest(String url) throws IOException {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new IOException("HTTP GET request failed with response code: " + response.getStatusCodeValue());
            }
        } catch (Exception e) {
            throw new IOException("Error making HTTP GET request: " + e.getMessage(), e);
        }
    }
    public String buildApiUrl(String tags, String cuisine, List<String> diet,
                              List<String> intolerance, List<String> includeIngredients,
                              List<String> excludeIngredients) {

        // Implement logic to construct the API URL using UriComponentsBuilder
        return UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/")
                .path("recipes/random")
                .queryParam("tags", tags)
                .queryParam("cuisine", cuisine)
                .queryParam("diet", diet)
                .queryParam("intolerance", intolerance)
                .queryParam("includeIngredients", includeIngredients)
                .queryParam("excludeIngredients", excludeIngredients)
                .queryParam("instructionsRequired", true)
                .queryParam("number", 1)
                .queryParam("apiKey", apiConfig.getApiKey())
                .toUriString();
    }

    public ResponseEntity<String> handleJsonResponse(String jsonResponse) throws JsonProcessingException {
        // Implement logic to handle the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        ResultsResponse response = objectMapper.readValue(jsonResponse, ResultsResponse.class);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        List<Recipe> recipeArray = response.getRecipes();
        if (recipeArray != null && !recipeArray.isEmpty()) {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipeArray);
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public List<Results> getAvailableRecipes() {
        System.out.println(kitchenRepository.findAll() );
        return kitchenRepository.findAll();
    }
}
