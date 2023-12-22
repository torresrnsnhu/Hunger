package com.api.perfectchef.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UserEntity {
    private ObjectId id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private byte[] storeHash;
    private byte[] storeSalt;

    public UserEntity(String email, String phoneNumber){
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
