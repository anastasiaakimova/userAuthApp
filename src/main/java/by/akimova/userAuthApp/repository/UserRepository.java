package by.akimova.userAuthApp.repository;

import by.akimova.userAuthApp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*****************************************************************************************
 * Repository interface for class {@link UserEntity}.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByMail(String mail);

}
