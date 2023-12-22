package com.api.perfectchef.localrecipes.controller;

import com.api.perfectchef.localrecipes.entity.dto.RecipeDto;
import com.api.perfectchef.localrecipes.service.LocalKitchenService;
import com.api.perfectchef.localrecipes.entity.RecipeEntity;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;

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
    //Get Recipe By Id
//    @GetMapping("/byId/{id}")
//    public LocalRecipeDto getLocalRecipeById(@PathVariable("id")ObjectId id){
//        return convertToDto(local.findRecipeById(id));
//    }
    @GetMapping("/byTitle/{title}")
    public RecipeDto getLocalRecipeByTitle(@PathVariable("title")String title){
        return convertToDto(local.findRecipeByTitle(title));
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
    @DeleteMapping("/{title}")
    public void deleteRecipe(@PathVariable("title")String title){
        local.removeRecipeByTitle(title);
    }
}
