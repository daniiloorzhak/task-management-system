package ru.oorzhak.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oorzhak.taskmanagementsystem.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
