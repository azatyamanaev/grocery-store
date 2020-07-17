package ru.itis.grocerystore.security.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.security.authentication.JwtAuthentication;
import ru.itis.grocerystore.services.UserService;

// проверить аутентификацию пользователя
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    // секретный ключ, которым мы подписываем токен
    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private UserService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthentication jwtAuthentication = (JwtAuthentication) authentication;
        User userDetails = (User) userDetailsService.loadUserByUsername(jwtAuthentication.getName());
        if (userDetails != null && userDetails.getCurrentToken().isNotExpired()) {
            jwtAuthentication.setUserDetails(userDetails);
            jwtAuthentication.setAuthenticated(true);

        } else {
            throw new BadCredentialsException("Bad Token");
        }
        return jwtAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthentication.class.equals(authentication);
    }
}
