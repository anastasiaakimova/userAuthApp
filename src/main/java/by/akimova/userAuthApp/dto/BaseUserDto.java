package by.akimova.userAuthApp.dto;

import by.akimova.userAuthApp.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseUserDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String phoneNumber;
    private LocalDateTime birthDate;
}
