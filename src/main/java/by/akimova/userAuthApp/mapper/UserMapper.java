package by.akimova.userAuthApp.mapper;

import by.akimova.userAuthApp.dto.CreateUserDto;
import by.akimova.userAuthApp.dto.UserDto;
import by.akimova.userAuthApp.model.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Mapper(componentModel = "spring")
@Component("userMapper")
public interface UserMapper {

    UserDto mapToDto(UserEntity userEntity);

    UserEntity mapToEntity(UserDto userDto);

    UserEntity createUserDtoMapToEntity(CreateUserDto createUserDto);

    //  User updateUserDtoMapToEntity(UpdateUserDto updateUserDto);

    List<UserDto> mapToListDto(List<UserEntity> userEntityList);

    List<UserEntity> mapToEntityList(List<UserDto> userDtoList);

}