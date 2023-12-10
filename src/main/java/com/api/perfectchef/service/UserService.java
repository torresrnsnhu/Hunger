package com.api.perfectchef.service;

import com.api.perfectchef.repositories.UserRepository;
import com.api.perfectchef.service.models.UserData;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository usersRepository;

    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public boolean userExists(UserData user) {
        if (usersRepository.findByUsername(user.getUsername()) == null) {
            throw new RuntimeException("User does not exist");
        }
        return false;
    }
}
