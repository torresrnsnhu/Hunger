package com.api.perfectchef.repositories;


import com.api.perfectchef.service.models.RecipeEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalKitchenRepository extends MongoRepository<RecipeEntity, ObjectId> {
    RecipeEntity findRecipeBy(String recipe);
}
