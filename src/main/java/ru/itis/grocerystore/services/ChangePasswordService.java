package ru.itis.grocerystore.services;

import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.models.User;

import java.util.Optional;

public interface ChangePasswordService {
    Optional<UserDto> findByEmail(String email);
    void createPasswordResetTokenForUser(UserDto userDto);
    String validatePasswordResetToken(long id, String token);
    void changeUserPassword(User user, String password);
}

