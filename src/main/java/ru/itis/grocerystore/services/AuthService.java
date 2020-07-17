package ru.itis.grocerystore.services;

import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;

import java.util.Optional;

public interface AuthService {
    Optional<UserDto> signIn(SignInDto signInDto);
    void logout(String auth);
}
