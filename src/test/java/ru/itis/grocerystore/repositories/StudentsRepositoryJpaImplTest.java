package ru.itis.grocerystore.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.grocerystore.config.TestApplicationConfig;
import ru.itis.grocerystore.models.Student;
import ru.itis.grocerystore.models.Teacher;

public class StudentsRepositoryJpaImplTest {

    private StudentsRepository studentsRepository;

    @BeforeEach
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
         studentsRepository = context.getBean("studentsRepositoryJpaImpl", StudentsRepository.class);
    }

    @Test
    public void whenSave_ThenTeacherIsPresent() {
        Student student = Student.builder()
                .login("arr")
                .name("Arthur")
                .lastName("Hisamov")
                .build();
        studentsRepository.save(student);
        assert studentsRepository.find(1L).isPresent();
    }

    @Test
    public void whenFind_thenReturnTeacher() {

        //given
        Student student = Student.builder()
                .login("arr")
                .name("Arthur")
                .lastName("Hisamov")
                .build();
        studentsRepository.save(student);

        //when
        Student found = studentsRepository.find(1L).get();

        //then
        assert found.getLastName().equals(student.getLastName());
    }

    @Test
    public void checkUpdate() {
        Student student = Student.builder()
                .login("arr")
                .name("Arthur")
                .lastName("Hisamov")
                .build();
        studentsRepository.save(student);
        String previousLastName = student.getLastName();
        student.setLastName("Sid");
        studentsRepository.update(student);
        assert !studentsRepository.find(1L).get().getLastName().equals(previousLastName);
    }

    @Test
    public void whenSaveSeveral_thenSizeOfResultListMoreThanOne() {
        Student student = Student.builder()
                .login("arr")
                .name("Arthur")
                .lastName("Hisamov")
                .build();
        studentsRepository.save(student);
        studentsRepository.save(Student.builder()
                .name("Ivan")
                .lastName("Petrov")
                .login("stud")
                .build());
        assert studentsRepository.findAll().size() == 2;
    }
}
