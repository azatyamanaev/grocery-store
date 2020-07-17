package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.models.Token;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.TokensRepository;
import ru.itis.grocerystore.repositories.UsersRepository;


import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private TokensRepository tokensRepository;

    @Override
    public UserDetails loadUserByUsername(String value) throws UsernameNotFoundException {
        Optional<Token> authenticationCandidate = tokensRepository.findFirstByValue(value);
        if (authenticationCandidate.isPresent()) {
            Token token = authenticationCandidate.get();
            User user = token.getUser();
            user.setCurrentToken(token);
            return user;
        } else throw new UsernameNotFoundException("Login not found");
    }



}
