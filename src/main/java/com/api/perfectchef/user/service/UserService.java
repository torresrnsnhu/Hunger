package com.api.perfectchef.user.service;

import com.api.perfectchef.exception.BadRequestException;
import com.api.perfectchef.exception.NotFoundException;
import com.api.perfectchef.user.repository.UserRepository;
import com.api.perfectchef.user.entity.dto.UserDto;
import com.api.perfectchef.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    private UserDto convertToDto(UserEntity userEntity){
        return mapper.map(userEntity, UserDto.class);
    }
    private UserEntity convertToEntity(UserDto userDto){
        return mapper.map(userDto, UserEntity.class);
    }

    public UserEntity searchByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDto> findAllUsers() {
        var userEntityList = new ArrayList<>(userRepository.findAll());
        return userEntityList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public UserDto findUserById(ObjectId  id) {
        var userEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User by id " + id + " was not found")
        );
        return convertToDto(userEntity);
    }

    public UserDto findUserByUsername(String username) {
        var userEntity = userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException("User by username " + username + " was not found")
        );
        return convertToDto(userEntity);
    }

    private byte[] createSalt() {
        var random = new SecureRandom();
        var salt = new byte[128];
        random.nextBytes(salt);
        return salt;
    }
    private byte[] createPasswordHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        return md.digest(
                password.getBytes(StandardCharsets.UTF_8)
        );
    }
    public UserDto createUser(UserDto userDto, String password) throws NoSuchAlgorithmException {
        var user = convertToEntity(userDto);
        if (password.isBlank()) throw new IllegalArgumentException("Password is required");

        var existEmail = userRepository.selectExistsEmail(user.getEmail());
        if (existEmail)  throw new BadRequestException("Email " + user.getEmail() + " is already taken");

        byte[] salt = createSalt();
        byte[] passwordHash = createPasswordHash(password, salt);

        user.setStoreSalt(salt);
        user.setStoreHash(passwordHash);
        userRepository.save(user);
        return convertToDto(user);
    }

    public void updateUser(ObjectId id, UserDto userDto, @NotNull String password) throws NoSuchAlgorithmException {
        var user = findIdOrThrow(id);
        var userParam = convertToEntity(userDto);
        user.setEmail(userParam.getEmail());
        user.setUsername(userParam.getUsername());
        user.setPhoneNumber(userParam.getPhoneNumber());
        //Password check
        if (!password.isBlank()){
            byte[] salt = createSalt();
            byte[] passwordHash = createPasswordHash(password, salt);
            user.setStoreSalt(salt);
            user.setStoreHash(passwordHash);
        }
        userRepository.save(user);
    }

    public void removeUserById(ObjectId id) {
        findIdOrThrow(id);
        userRepository.deleteById(id);
    }

    public void removeUserByUsername(String username) {
        userRepository.deleteByUsername(findUsernameOrThrow(username).getUsername());
    }

    private UserEntity findUsernameOrThrow(final String username){
        return userRepository
                .findByUsername(username).orElseThrow(
                        () -> new NotFoundException("User by username " + username + " was not found")
                );
    }
    private UserEntity findIdOrThrow(final ObjectId id){
        return userRepository
                .findById(id).orElseThrow(
                        () -> new NotFoundException("User by id " + id + " was not found")
                );
    }
}
