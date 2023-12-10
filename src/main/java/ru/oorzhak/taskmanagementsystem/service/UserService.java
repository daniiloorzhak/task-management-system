package ru.oorzhak.taskmanagementsystem.service;

import ru.oorzhak.taskmanagementsystem.dto.UserRegisterDTO;
import ru.oorzhak.taskmanagementsystem.model.User;

public interface UserService {
    Long save(UserRegisterDTO userRegisterDTO);
    User getCurrentUser();
}
