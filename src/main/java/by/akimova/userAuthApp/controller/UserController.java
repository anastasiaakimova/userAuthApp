package by.akimova.userAuthApp.controller;

import by.akimova.userAuthApp.dto.CreateUserDto;
import by.akimova.userAuthApp.dto.UserDto;
import by.akimova.userAuthApp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*****************************************************************************************
 * REST controller user connected requests.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    /**
     * The method add new user.
     *
     * @param createUserDto This is dto with all information and body.
     * @return response with body of created user and status ok.
     */

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody CreateUserDto createUserDto) {
        var savedUser = userService.save(createUserDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * The method shows all users.
     *
     * @return ResponseEntity with list of users and status ok.
     */

    @GetMapping
    // @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    /**
     * The method shows user by id.
     *
     * @param id This is id of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */

    @GetMapping("/{id}")
    // @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        var userDto = userService.getById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     * The method shows user by mail.
     *
     * @param mail This is mail of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */
    @GetMapping("mail/{mail}")
    // @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<?> getByMail(@PathVariable(value = "mail") String mail) {
        var userDto = userService.findByMail(mail);
        return ResponseEntity.ok(userDto);
    }

    /**
     * The method delete user.
     *
     * @param id This is user's id which should be deleted.
     * @return response status no_content.
     */
    @DeleteMapping("/{id}")
    // @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
