package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.models.FtlEnum;
import ru.itis.grocerystore.models.PasswordResetToken;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.PasswordTokenRepository;
import ru.itis.grocerystore.repositories.UsersRepository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordTokenRepository passwordTokenRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MessageConvertorService messageConvertorService;

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

    @Override
    public Optional<UserDto> findByEmail(String email) {
        Optional<User> optionalUser = usersRepository.findByEmail(email);
        return optionalUser.map(user -> UserDto.builder()
                .email(user.getEmail())
                .login(user.getLogin())
                .role(user.getRole())
                .id(user.getId())
                .build());
    }

    @Override
    public void createPasswordResetTokenForUser(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .role(userDto.getRole())
                .email(userDto.getEmail())
                .login(userDto.getLogin())
                .build();
        String token = UUID.randomUUID().toString();
        emailService.sendNotification("Регистрация",
                messageConvertorService.fromEmailToFtl(user.getId() + "&token=" + token, FtlEnum.RESET),
                user.getEmail());
        PasswordResetToken myToken = PasswordResetToken.builder()
                .token(token)
                .user(user)
                .build();
        passwordTokenRepository.save(myToken);
    }

    public String validatePasswordResetToken(long id, String token) {
        Optional<PasswordResetToken> optionalPasswordResetToken = passwordTokenRepository.findByToken(token);
        if (!optionalPasswordResetToken.isPresent())
            return null;
        PasswordResetToken passToken = optionalPasswordResetToken.get();

        if ((passToken == null) || (passToken.getUser()
                .getId() != id)) {
            return "invalidToken";
        }

        Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate()
                .getTime() - cal.getTime()
                .getTime()) <= 0) {
            return "expired";
        }

        User user = passToken.getUser();
        Authentication auth = new UsernamePasswordAuthenticationToken(
                user, null, Arrays.asList(
                new SimpleGrantedAuthority("CHANGE__PASSWORD__PRIVILEGE")));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return null;
    }

    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        usersRepository.save(user);
    }

}
