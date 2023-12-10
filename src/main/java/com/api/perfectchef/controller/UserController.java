package com.api.perfectchef.controller;


import com.api.perfectchef.repositories.UserRepository;
import com.api.perfectchef.service.UserService;
import com.api.perfectchef.service.models.Intolerances;
import com.api.perfectchef.service.models.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository usersRepository;
    private UserService userService;

    public UserController(UserRepository usersRepository, UserService userService) {
        this.usersRepository = usersRepository;
        this.userService = userService;
    }

    @PutMapping("/addUser")
    public ResponseEntity<UserData> addUser(@RequestBody UserData user) {
        this.usersRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserData>> getAllUsers() {
        List<UserData> users = this.usersRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getUser/{username}")
    public ResponseEntity<UserData> getUser(@PathVariable String username) {
        UserData user = this.usersRepository.findByUsername(username);
        if(!userService.userExists(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @PostMapping("/addIntolerance/{username}/{intolerance}")
    public ResponseEntity<UserData> addIntolerance(@PathVariable String username, @PathVariable Intolerances intolerance) {
        UserData user = this.usersRepository.findByUsername(username);
        if(!userService.userExists(user)) {
            return ResponseEntity.notFound().build();
        }
        user.getIntolerances().add(intolerance);
        this.usersRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
