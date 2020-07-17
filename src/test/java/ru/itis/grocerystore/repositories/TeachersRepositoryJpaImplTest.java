package ru.itis.grocerystore.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.grocerystore.config.TestApplicationConfig;
import ru.itis.grocerystore.models.Teacher;

public class TeachersRepositoryJpaImplTest {

    private TeachersRepository teachersRepository;

    @BeforeEach
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        teachersRepository = context.getBean("teachersRepositoryJpaImpl", TeachersRepository.class);
    }

    @Test
    public void save() {
        teachersRepository.save(Teacher.builder().build());

    }
}
