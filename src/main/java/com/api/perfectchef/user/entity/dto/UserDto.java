package com.api.perfectchef.user.entity.dto;

import lombok.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String email;
    private String phoneNumber;
    private String password;
}
