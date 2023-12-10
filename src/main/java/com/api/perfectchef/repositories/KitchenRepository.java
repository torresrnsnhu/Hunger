package com.api.perfectchef.repositories;

import com.api.perfectchef.service.models.model.Recipe;
import com.api.perfectchef.service.models.model.Results;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface KitchenRepository extends MongoRepository<Results, ObjectId> {
    Results findByRecipes(List<Recipe> recipes);
}
