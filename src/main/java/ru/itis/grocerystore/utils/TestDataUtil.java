package ru.itis.grocerystore.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.repositories.CompaniesRepository;
import ru.itis.grocerystore.repositories.StudentsRepository;
import ru.itis.grocerystore.repositories.TeachersRepository;
import ru.itis.grocerystore.repositories.UsersRepository;

import javax.transaction.Transactional;

@Component
public class TestDataUtil {

    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private CompaniesRepository companiesRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void intializeData() {
        Student student = Student.builder()
                .login("arr")
                .name("Arthur")
                .lastName("Hisamov")
                .role(Role.STUDENT)
                .state(State.CONFIRMED)
                .build();
        studentsRepository.save(student);
        Teacher teacher = Teacher.builder()
                .name("Marsel")
                .login("teacher")
                .lastName("Sidikov")
                .role(Role.TEACHER)
                .state(State.CONFIRMED)
                .build();
        teachersRepository.save(teacher);
        Company company = Company.builder()
                .name("Mera")
                .login("company")
                .about("good")
                .role(Role.COMPANY)
                .state(State.CONFIRMED)
                .build();
        companiesRepository.save(company);
    }

}
