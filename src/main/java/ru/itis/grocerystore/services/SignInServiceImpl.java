package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.UsersRepository;

import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserDto> signIn(SignInDto signInDto) {
        Optional<User> optionalUser = usersRepository.findByLogin(signInDto.getLogin());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(signInDto.getPassword(), user.getPassword())) {
                return Optional.of(UserDto.builder()
                        .email(user.getEmail())
                        .login(user.getLogin())
                        .role(user.getRole())
                        .id(user.getId())
                        .build());
            } else throw new AccessDeniedException("Wrong email/password");
        } else throw new AccessDeniedException("User not found");
    }
}
