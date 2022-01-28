package by.akimova.userAuthApp.dto;

import by.akimova.userAuthApp.model.Gender;
import by.akimova.userAuthApp.model.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private Role role;
    private LocalDateTime birthDate;
    private LocalDateTime registeredTime;
    private LocalDateTime updatedTime;
}
