package com.api.perfectchef.localrecipes.service;

import com.api.perfectchef.exception.NotFoundException;
import com.api.perfectchef.localrecipes.entity.RecipeEntity;
import com.api.perfectchef.localrecipes.repository.LocalKitchenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocalKitchenService {
    private final LocalKitchenRepository localKitchenRepository;

    public RecipeEntity findRecipeByTitle(String title) {
        return  findTitleOrThrow(title);
    }
    public RecipeEntity findRecipeById(int id) {
        return findIdOrThrow(id);
    }
    public void removeRecipeByTitle(String title) {
     localKitchenRepository.delete(findTitleOrThrow(title));
    }
    public RecipeEntity addRecipe(RecipeEntity recipe) {
        return localKitchenRepository.save(recipe);
    }
    public void updateRecipe(int id, RecipeEntity recipe) {
        this.findIdOrThrow(id);
        localKitchenRepository.save(recipe);
    }

    private RecipeEntity findIdOrThrow(final int id) {
        return localKitchenRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recipe by id " + id + " was not found")
        );
    }
    private RecipeEntity findTitleOrThrow(final String title) {
        return localKitchenRepository.findRecipeByTitle(title)
                .orElseThrow(() -> new NotFoundException("Recipe by title " + title + " was not found"));
    }
}
