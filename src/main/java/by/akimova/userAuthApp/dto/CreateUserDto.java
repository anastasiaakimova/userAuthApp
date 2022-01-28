package by.akimova.userAuthApp.dto;

import by.akimova.userAuthApp.model.Gender;
import lombok.Builder;
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
@NoArgsConstructor
public class CreateUserDto extends BaseUserDto {

    private String mail;
    private String password;

    @Builder
    public CreateUserDto(String firstName, String lastName, Gender gender, String phoneNumber,
                         String password, LocalDateTime birthDate, String mail) {
        super(firstName, lastName, gender, phoneNumber, birthDate);
        this.mail = mail;
        this.password = password;
    }
}
