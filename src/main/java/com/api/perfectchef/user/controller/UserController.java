package com.api.perfectchef.user.controller;

import com.api.perfectchef.user.service.UserService;
import com.api.perfectchef.user.entity.dto.UserDto;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public Iterable<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }
    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable("id") ObjectId id){
        return userService.findUserById(id);
    }
    @GetMapping("/users/username/{username}")
    public UserDto getUserByUsername(@PathVariable("username") String username){
        return userService.findUserByUsername(username);
    }
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") ObjectId id){
        userService.removeUserById(id);
    }
    @DeleteMapping("/users/username/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByUsername(@PathVariable("username") String username){
        userService.removeUserByUsername(username);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody UserDto userDto) throws NoSuchAlgorithmException {
        return userService.createUser(userDto, userDto.getPassword());
    }
    @PutMapping("users/update/{id}")
    public void updateUser(@PathVariable("id") ObjectId id,
                           @Valid @RequestBody UserDto userDto) throws NoSuchAlgorithmException {
        userService.updateUser(id, userDto, userDto.getPassword());
    }

}
