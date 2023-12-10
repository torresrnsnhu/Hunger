package com.api.perfectchef.controller;

import com.api.perfectchef.service.KitchenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recipes")
public class KitchenApiController {
    private final KitchenService kitchenService;

    /**
     * @param tags -
     * @return - JSON response of recipes
     */
    @GetMapping
    public ResponseEntity<String> getAllAvailableRecipes(
            @RequestParam(value = "tags") String tags,
            @RequestParam(value = "cuisine", required = false) String cuisine,
            @RequestParam(value = "diet", required = false) List<String> diet,
            @RequestParam(value = "intolerances", required = false) List<String> intolerance,
            @RequestParam(value = "includeIngredients", required = false) List<String> includeIngredients,
            @RequestParam(value = "excludeIngredients", required = false) List<String> excludeIngredients) {

        try {
            // Construct URL using UriComponentsBuilder
            String url = kitchenService.buildApiUrl(tags, cuisine, diet, intolerance, includeIngredients, excludeIngredients);

            // Make HTTP GET request using RestTemplate or WebClient
            String jsonResponse = kitchenService.makeHttpGetRequest(url);

            // Handle JSON response
            System.out.println(jsonResponse);
            return kitchenService.handleJsonResponse(jsonResponse);
        } catch (IOException e) {
            // Handle IOException
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error making API request: " + e.getMessage());
        }
    }
}
