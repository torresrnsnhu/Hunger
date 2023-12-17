package com.api.perfectchef.repositories;

import com.api.perfectchef.service.models.apimodel.Recipe;
import com.api.perfectchef.service.models.apimodel.Results;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KitchenRepository extends MongoRepository<Results, ObjectId> {
}
