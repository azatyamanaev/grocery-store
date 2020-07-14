package ru.itis.grocerystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import ru.itis.grocerystore.config.AppConfig;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.State;
import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.TeachersRepository;

@SpringBootApplication
@Import(AppConfig.class)
public class GroceryStoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GroceryStoreApplication.class, args);
        TeachersRepository teachersRepository = (TeachersRepository) context.getBean("teachersRepositoryJpaImpl");
        Teacher teacher = Teacher.builder()
                .name("Mars")
                .lastName("Sid")
                .role(Role.TEACHER)
                .state(State.CONFIRMED)
                .password("008")
                .position("assistant")
                .build();
        System.out.println(teachersRepository.findAll().get(0).getImage().getSourceFile());
    }

}
