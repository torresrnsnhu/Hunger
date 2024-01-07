package com.api.perfectchef.localrecipes.controller;

import com.api.perfectchef.localrecipes.entity.RecipeEntity;
import com.api.perfectchef.localrecipes.entity.dto.RecipeDto;
import com.api.perfectchef.localrecipes.service.LocalKitchenService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/local/recipes")
@PreAuthorize("isAuthenticated()")
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
    public void putRecipe(@PathVariable("id")int id, @Valid @RequestBody RecipeDto dto){
            var recipeEntity = convertToEntity(dto);
            local.updateRecipe(id, recipeEntity);
    }
    @DeleteMapping("/{title}")
    public void deleteRecipe(@PathVariable("title")String title){
        local.removeRecipeByTitle(title);
    }
}
