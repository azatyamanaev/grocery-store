package ru.itis.grocerystore.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.grocerystore.config.TestApplicationConfig;
import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.User;

import java.util.List;

public class TeachersRepositoryJpaImplTest {

    private TeachersRepository teachersRepository;

    @BeforeEach
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        teachersRepository = context.getBean("teachersRepositoryJpaImpl", TeachersRepository.class);
    }

    @Test
    public void whenSave_ThenTeacherIsPresent() {
        Teacher teacher = Teacher.builder()
                .name("Marsel")
                .login("teacher")
                .lastName("Sidikov")
                .build();
        teachersRepository.save(teacher);
        assert teachersRepository.find(1L).isPresent();
    }

    @Test
    public void whenFind_thenReturnTeacher() {

        //given
        Teacher teacher = Teacher.builder()
                .name("Marsel")
                .login("teacher")
                .lastName("Sidikov")
                .build();
        teachersRepository.save(teacher);

        //when
       Teacher found = teachersRepository.find(1L).get();

        //then
        assert found.getLastName().equals(teacher.getLastName());
    }

    @Test
    public void checkUpdate() {
        Teacher teacher = Teacher.builder()
                .name("Marsel")
                .login("teacher")
                .lastName("Sidikov")
                .build();
        teachersRepository.save(teacher);
        String previousLastName = teacher.getLastName();
        teacher.setLastName("Sid");
        teachersRepository.update(teacher);
        assert !teachersRepository.find(1L).get().getLastName().equals(previousLastName);
    }

    @Test
    public void whenSaveSeveral_thenSizeOfResultListMoreThanOne() {
        Teacher teacher = Teacher.builder()
                .name("Marsel")
                .login("teacher")
                .lastName("Sidikov")
                .build();
        teachersRepository.save(teacher);
        teachersRepository.save(Teacher.builder()
        .name("Ivan")
        .lastName("Sidorov")
        .login("t")
        .build());
        assert teachersRepository.findAll().size() == 2;
    }
}
