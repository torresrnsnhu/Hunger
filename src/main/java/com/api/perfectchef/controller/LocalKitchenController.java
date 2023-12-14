package com.api.perfectchef.controller;

import com.api.perfectchef.service.KitchenService;
import com.api.perfectchef.service.LocalKitchenService;
import com.api.perfectchef.service.models.RecipeEntity;
import com.api.perfectchef.service.models.dto.RecipeDto;
import com.api.perfectchef.service.models.apimodel.Results;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/recipes")
public class LocalKitchenController {

    private final LocalKitchenService local;
    private final ModelMapper mapper;

    private RecipeDto convertToDto(RecipeEntity entity) {
        return mapper.map(entity, RecipeDto.class);
    }

    private RecipeEntity convertToEntity(RecipeDto dto) {
        return mapper.map(dto, RecipeEntity.class);
    }
    @GetMapping("/{id}")
    public RecipeDto getLocalRecipeById(@PathVariable("id")ObjectId id){
        return convertToDto(local.findRecipeById(id));
    }
    @PostMapping
    public RecipeDto postRecipe(@Valid @RequestBody RecipeDto dto){
        var entity = convertToEntity(dto);
        var recipe = local.addRecipe(entity);
        return convertToDto(recipe);
    }
    @PutMapping("/{id}")
    public void putRecipe(@PathVariable("id")ObjectId id, @Valid @RequestBody RecipeDto dto){
        if(!id.equals(dto.get_id())) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID in path must match");}
            var recipeEntity = convertToEntity(dto);
            local.updateRecipe(id, recipeEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id")ObjectId id){
        local.removeRecipeById(id);
    }
}
