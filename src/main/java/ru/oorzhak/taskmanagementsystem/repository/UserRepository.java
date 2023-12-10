package ru.oorzhak.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oorzhak.taskmanagementsystem.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String name);
    Boolean existsByUsername(String name);
}
