package com.api.perfectchef.controller;

import com.api.perfectchef.service.KitchenService;
import com.api.perfectchef.service.LocalKitchenService;
import com.api.perfectchef.service.models.RecipeEntity;
import com.api.perfectchef.service.models.dto.LocalRecipeDto;
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

    private LocalRecipeDto convertToDto(RecipeEntity entity) {
        return mapper.map(entity, LocalRecipeDto.class);
    }

    private RecipeEntity convertToEntity(LocalRecipeDto dto) {
        return mapper.map(dto, RecipeEntity.class);
    }
    //Get Recipe By Id
//    @GetMapping("/byId/{id}")
//    public LocalRecipeDto getLocalRecipeById(@PathVariable("id")ObjectId id){
//        return convertToDto(local.findRecipeById(id));
//    }
    @GetMapping("/byTitle/{title}")
    public LocalRecipeDto getLocalRecipeByTitle(@PathVariable("title")String title){
        return convertToDto(local.findRecipeByTitle(title));
    }
    @PostMapping
    public LocalRecipeDto postRecipe(@Valid @RequestBody LocalRecipeDto dto){
        var entity = convertToEntity(dto);
        var recipe = local.addRecipe(entity);
        return convertToDto(recipe);
    }
    @PutMapping("/{id}")
    public void putRecipe(@PathVariable("id")ObjectId id, @Valid @RequestBody LocalRecipeDto dto){
        if(!id.equals(dto.get_id())) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID in path must match");}
            var recipeEntity = convertToEntity(dto);
            local.updateRecipe(id, recipeEntity);
    }
    @DeleteMapping("/{title}")
    public void deleteRecipe(@PathVariable("title")String title){
        local.removeRecipeByTitle(title);
    }
}
