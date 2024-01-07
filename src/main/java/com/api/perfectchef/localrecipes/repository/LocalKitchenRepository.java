package com.api.perfectchef.localrecipes.repository;


import com.api.perfectchef.localrecipes.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LocalKitchenRepository extends JpaRepository<RecipeEntity, Integer> {
    Optional<RecipeEntity> findRecipeByTitle(String title);
    Optional<RecipeEntity> deleteRecipeByTitle(String title);
}
