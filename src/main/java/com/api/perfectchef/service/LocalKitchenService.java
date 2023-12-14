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
    private final LocalKitchenRepository usersRepository;

    public RecipeEntity findRecipeByTitle(String title) {
        return  usersRepository.findRecipeBy(title);
    }
    public RecipeEntity findRecipeById(ObjectId id) {
        return findOrThrow(id);
    }
    public void removeRecipeById(ObjectId id) {
        usersRepository.deleteById(id);
    }
    public RecipeEntity addRecipe(RecipeEntity recipe) {
        return usersRepository.save(recipe);
    }
    public void updateRecipe(ObjectId id, RecipeEntity recipe) {
        this.findOrThrow(id);
        usersRepository.save(recipe);
    }

    private RecipeEntity findOrThrow(final ObjectId id) {
        return usersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recipe by id " + id + " was not found")
        );
    }
}
