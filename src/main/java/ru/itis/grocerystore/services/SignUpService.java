package ru.itis.grocerystore.services;

import ru.itis.grocerystore.dto.SignUpDto;
import ru.itis.grocerystore.dto.UserDto;

import java.util.Optional;

public interface SignUpService {
    UserDto signUp(SignUpDto form);
    Optional<UserDto> confirm(String code);
}
