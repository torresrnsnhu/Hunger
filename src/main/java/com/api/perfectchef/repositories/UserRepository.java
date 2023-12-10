package com.api.perfectchef.repositories;


import com.api.perfectchef.service.models.UserData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserData, ObjectId> {
    UserData findByUsername(String username);
}
