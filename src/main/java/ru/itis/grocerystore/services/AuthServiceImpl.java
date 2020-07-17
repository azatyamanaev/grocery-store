package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.models.Token;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.TokensRepository;
import ru.itis.grocerystore.repositories.UsersRepository;
import ru.itis.grocerystore.security.authentication.JwtAuthentication;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private TokensRepository tokensRepository;
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
                String value = UUID.randomUUID().toString();
                Token token = Token.builder()
                        .createdAt(LocalDateTime.now())
                        .expiredDateTime(LocalDateTime.now().plusSeconds(3600000))
                        .value(value)
                        .user(user)
                        .build();

                tokensRepository.save(token);
                JwtAuthentication jwtAuthentication = new JwtAuthentication();
                jwtAuthentication.setToken(token.getValue());
                jwtAuthentication.setAuthenticated(true);
                jwtAuthentication.setUserDetails(user);
                SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
                return Optional.of(UserDto.builder()
                        .email(user.getEmail())
                        .login(user.getLogin())
                        .role(user.getRole())
                        .id(user.getId())
                        .build());
            } else throw new AccessDeniedException("Wrong email/password");
        } else throw new AccessDeniedException("User not found");
    }

    @Override
    public void logout(String auth) {
        tokensRepository.deleteTokenByValue(auth);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
