package ru.itis.grocerystore.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.grocerystore.config.TestApplicationConfig;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.State;
import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.User;

import java.util.List;

public class UsersRepositoryImplTest {

    private UsersRepository usersRepository;

    @BeforeEach
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        usersRepository = context.getBean("usersRepositoryImpl", UsersRepository.class);
    }

    @Test
    public void weheSave_ThenUserIsPresent() {
        User user = User.builder()
                .login("nano")
                .name("Aidar")
                .build();
        usersRepository.save(user);
        assert usersRepository.find(1L).isPresent();
    }

    @Test
    public void whenFind_thenReturnUser() {

        //given
        User user = User.builder()
                .login("nano")
                .name("Aidar")
                .build();
        usersRepository.save(user);

        //when
        User found = usersRepository.findByLogin("nano").get();

        //then
        assert user.getLogin().equals(found.getLogin());
    }

    @Test
    public void whenSaveSeveral_thenSizeOfResultListMoreThanOne() {

        //given
        User user = User.builder()
                .login("nano")
                .name("Aidar")
                .build();
        usersRepository.save(user);
        User user1 = User.builder()
                .login("azyam")
                .name("Azat")
                .build();
        usersRepository.save(user1);

        //when
        List<User> users = usersRepository.findAll();

        //then
        assert users.size() == 2;
    }

    @Test
    public void checkUpdate() {

        User user = User.builder()
                .login("nano")
                .name("Aidar")
                .build();
        usersRepository.save(user);
        String previousName = user.getName();
        user.setName("Ai");
        usersRepository.update(user);


        assert !usersRepository.find(1L).get().getName().equals(previousName);
    }
}
