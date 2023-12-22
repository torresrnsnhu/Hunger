package com.api.perfectchef.user.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private ObjectId id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
}
