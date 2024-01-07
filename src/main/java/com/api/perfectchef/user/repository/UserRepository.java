package com.api.perfectchef.user.repository;

import com.api.perfectchef.user.entity.UserEntity;
import com.api.perfectchef.user.entity.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, UUID> {
    @Query(
            "" +
                    "SELECT CASE WHEN COUNT(u) > 0 THEN " +
                    "TRUE ELSE FALSE END " +
                    "FROM UserEntity u " +
                    "WHERE u.email = ?1"
    )
    Boolean selectExistsEmail(String email);
    UserEntity findByEmail(String email);
}
