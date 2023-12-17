package com.api.perfectchef.service;

import com.api.perfectchef.exception.NotFoundException;
import com.api.perfectchef.repositories.LocalKitchenRepository;
import com.api.perfectchef.service.models.RecipeEntity;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LocalKitchenService {
    private final LocalKitchenRepository localKitchenRepository;

    public RecipeEntity findRecipeByTitle(String title) {
        return  findTitleOrThrow(title);
    }
    public RecipeEntity findRecipeById(ObjectId id) {
        return findIdOrThrow(id);
    }
    public void removeRecipeByTitle(String title) {
     localKitchenRepository.delete(findTitleOrThrow(title));
    }
    public RecipeEntity addRecipe(RecipeEntity recipe) {
        return localKitchenRepository.save(recipe);
    }
    public void updateRecipe(ObjectId id, RecipeEntity recipe) {
        this.findIdOrThrow(id);
        localKitchenRepository.save(recipe);
    }

    private RecipeEntity findIdOrThrow(final ObjectId id) {
        return localKitchenRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recipe by id " + id + " was not found")
        );
    }
    private RecipeEntity findTitleOrThrow(final String title) {
        return localKitchenRepository.findRecipeByTitle(title)
                .orElseThrow(() -> new NotFoundException("Recipe by title " + title + " was not found"));
    }
}
