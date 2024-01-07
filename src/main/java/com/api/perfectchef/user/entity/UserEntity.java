package com.api.perfectchef.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(unique = true)
    private String email;
    private String mobileNumber;
    private byte[] storedHash;
    private byte[] storedSalt;

    public UserEntity(String email, String mobileNumber) {
        this.email = email;
        this.mobileNumber = mobileNumber;
    }
}
