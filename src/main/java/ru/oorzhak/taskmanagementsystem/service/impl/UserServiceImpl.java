package ru.oorzhak.taskmanagementsystem.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.oorzhak.taskmanagementsystem.dto.UserRegisterDTO;
import ru.oorzhak.taskmanagementsystem.model.Role;
import ru.oorzhak.taskmanagementsystem.model.User;
import ru.oorzhak.taskmanagementsystem.repository.UserRepository;
import ru.oorzhak.taskmanagementsystem.service.UserService;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Long save(UserRegisterDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername()))
            throw new RuntimeException();
        return userRepository.save(userRegisterDtoToUser(userDTO)).getId();
    }

    @Override
    public User getCurrentUser() {
        var authToken = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authToken.getName()).orElseThrow();
    }

    private User userRegisterDtoToUser (UserRegisterDTO dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .roles(Set.of(Role.ROLE_USER))
                .build();
    }
}
