package com.api.perfectchef.controller;

import com.api.perfectchef.service.KitchenService;
import com.api.perfectchef.service.models.RecipeEntity;
import com.api.perfectchef.service.models.dto.RecipeDto;
import com.api.perfectchef.service.models.apimodel.Results;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/recipes")
public class LocalKitchenController {

    private final KitchenService kitchenService;
    private final ModelMapper mapper;

    private RecipeDto convertToDto(RecipeEntity entity) {
        return mapper.map(entity, RecipeDto.class);
    }

    private RecipeEntity convertToEntity(RecipeDto dto) {
        return mapper.map(dto, RecipeEntity.class);
    }

    @GetMapping("/")
    public ResponseEntity<List<Results>> getAllSavedRecipes() {
        return new ResponseEntity<>(kitchenService.getAvailableRecipes(), HttpStatus.OK);
    }
}
