package com.api.perfectchef.user.repository;

import com.api.perfectchef.user.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository  extends MongoRepository<UserEntity, ObjectId> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN " +
    "TRUE ELSE FALSE END " +
    "FROM UserEntity u " +
    "WHERE u.email = ?1")
    Boolean selectExistsEmail(String email);
    UserEntity findByEmail(String email);
    Optional<UserEntity> findByUsername(String username);
    void deleteByUsername(String username);
}
