package by.akimova.userAuthApp.service;

import by.akimova.userAuthApp.dto.CreateUserDto;
import by.akimova.userAuthApp.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

/*****************************************************************************************
 * Service interface for class {@link by.akimova.userAuthApp.model.UserEntity}.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Component
public interface UserService {
    UserDto save(CreateUserDto createUserDto);

    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto update(Long id, UserDto userDto);

    void deleteById(Long id);

    UserDto findByMail(String mail);
}
