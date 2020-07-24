package ru.itis.grocerystore.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.itis.grocerystore.dto.SignUpDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.repositories.UsersRepository;

@SpringBootTest
public class SignUpServiceTest {
    @Autowired
    private SignUpService signUpService;
    @MockBean
    private UsersRepository usersRepository;

//    @Test
//    void signUp_test() {
//        SignUpDto signUpDto = SignUpDto.builder()
//                .email("email")
//                .password("password")
//                .login("login")
//                .role(Role.STUDENT).build();
//        UserDto userDto = signUpService.signUp(signUpDto);
//        Assert.assertEquals(UserDto.builder()
//                .email("email@stud.kpfu.ru")
//                .login("login")
//                .role(Role.STUDENT)
//                .build(), userDto);
//    }

}
