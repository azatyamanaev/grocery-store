package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.dto.SignUpDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.repositories.StudentsRepository;
import ru.itis.grocerystore.repositories.TeachersRepository;
import ru.itis.grocerystore.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private TeachersRepository teachersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MessageConvertorService messageConvertorService;

    @Override
    public UserDto signUp(SignUpDto form) {
        if (usersRepository.findByLogin(form.getLogin()).isPresent())
            return null;
        String emailEnding;
        if (form.getRole().equals(Role.STUDENT))
            emailEnding = "@stud.kpfu.ru";
        else
            emailEnding = "@stud.ru";

        User user = User.builder()
                .email(form.getEmail() + emailEnding)
                .login(form.getLogin())
                .password(passwordEncoder.encode(form.getPassword()))
                .state(State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .role(form.getRole())
                .build();
        System.out.println(form);
        if (form.getRole().equals(Role.STUDENT))
        {
            Student student = Student.builder()
                    .email(user.getEmail())
                    .login(form.getLogin())
                    .password(passwordEncoder.encode(form.getPassword()))
                    .state(State.NOT_CONFIRMED)
                    .confirmCode(user.getConfirmCode())
                    .role(form.getRole())
                    .build();
            studentsRepository.save(student);
        }
        else if (form.getRole().equals(Role.TEACHER))
        {
            Teacher teacher = Teacher.builder()
                    .email(user.getEmail())
                    .login(form.getLogin())
                    .password(passwordEncoder.encode(form.getPassword()))
                    .state(State.NOT_CONFIRMED)
                    .confirmCode(user.getConfirmCode())
                    .role(form.getRole())
                    .build();
            teachersRepository.save(teacher);
        }

        String text = messageConvertorService.fromEmailToFtl(user.getConfirmCode(), FtlEnum.CONFIRM);
        emailService.sendNotification("Регистрация", text, user.getEmail());

//        usersRepository.save(user);
        return UserDto.from(user);
    }

    @Override
    public Optional<UserDto> confirm(String code) {
        Optional<User> optionalUser = usersRepository.findByConfirmCode(code);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setState(State.CONFIRMED);
            usersRepository.update(user);
            return Optional.of(UserDto.builder()
                    .email(user.getEmail())
                    .login(user.getLogin())
                    .id(user.getId())
                    .build());
        }
        return Optional.empty();}
}
