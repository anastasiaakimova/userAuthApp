package by.akimova.userAuthApp.service.impl;

import by.akimova.userAuthApp.dto.CreateUserDto;
import by.akimova.userAuthApp.dto.UserDto;
import by.akimova.userAuthApp.exception.EntityNotFoundException;
import by.akimova.userAuthApp.mapper.UserMapper;
import by.akimova.userAuthApp.model.Role;
import by.akimova.userAuthApp.repository.UserRepository;
import by.akimova.userAuthApp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/*****************************************************************************************
 * The class is implementation of user's business logic.
 * The class is implementation of  {@link UserService} interface.
 * Wrapper for {@link UserRepository} + business logic.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional()
    public UserDto save(CreateUserDto createUserDto) {

        var today = LocalDateTime.now();
        var userEntity = userMapper.createUserDtoMapToEntity(createUserDto);

        userEntity.setPassword(userEntity.getPassword());
        userEntity.setRole(Role.USER);
        userEntity.setRegisteredTime(today);
        userEntity.setUpdatedTime(today);

        userRepository.save(userEntity);
        log.info("IN saveUser - new user with id: {} successfully added", userEntity.getId());

        return userMapper.mapToDto(userEntity);
    }

    @Override
    public UserDto getById(Long id) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
        var userDto = userMapper.mapToDto(userEntity);
        log.info("IN getById - user: {} found by id: {}", userDto, id);

        return userDto;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = userMapper.mapToListDto(userRepository.findAll());
        log.info("IN getAllUsers - {} users found", users.size());

        return users;
    }

    @Override
    @Transactional()
    public UserDto update(Long id, UserDto userDto) {
        return null;
    }

    @Override
    @Transactional()
    public void deleteById(Long id) {
        userRepository.deleteById(id);
        log.info("IN deleteUserById - user with id: {} successfully deleted", id);

    }

    @Override
    public UserDto findByMail(String mail) {
        var mailUser = userRepository.findByMail(mail)
                .orElseThrow(() -> new EntityNotFoundException("User doesn't exists"));
        log.info("IN findByMail - user found by mail: {}", mail);
        var userDto = userMapper.mapToDto(mailUser);

        return userDto;
    }
}