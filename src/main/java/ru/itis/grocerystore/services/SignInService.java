package ru.itis.grocerystore.services;

import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;

import java.util.Optional;

public interface SignInService {
    Optional<UserDto> signIn(SignInDto signInDto);
}

