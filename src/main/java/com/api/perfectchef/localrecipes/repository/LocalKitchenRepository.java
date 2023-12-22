package com.api.perfectchef.localrecipes.repository;


import com.api.perfectchef.localrecipes.entity.RecipeEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LocalKitchenRepository extends MongoRepository<RecipeEntity, ObjectId> {
    Optional<RecipeEntity> findRecipeByTitle(String title);
    Optional<RecipeEntity> deleteRecipeByTitle(String title);
}
