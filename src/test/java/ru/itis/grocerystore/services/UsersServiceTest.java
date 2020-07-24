package ru.itis.grocerystore.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.repositories.CompaniesRepository;
import ru.itis.grocerystore.repositories.StudentsRepository;
import ru.itis.grocerystore.repositories.TeachersRepository;
import ru.itis.grocerystore.repositories.UsersRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {

    @MockBean
    private StudentsRepository studentsRepository;
    @MockBean
    private CompaniesRepository companiesRepository;
    @MockBean
    private TeachersRepository teachersRepository;
    @Autowired
    private UsersService usersService;

    @Test
    public void finStudentTest() {
        given(this.studentsRepository.find(any()))
                .willReturn(java.util.Optional.of(new Student(33L, "student", "stud")));
        Student student = usersService.findStudent(33L);
        assert student.getId().equals(33L);
    }

    @Test
    public void findCompanyTest() {
        given(this.companiesRepository.find(any()))
                .willReturn(java.util.Optional.of(new Company(32L, "company", "com")));
        Company company = usersService.findCompany(32L);
        assert company.getId().equals(32L);
    }

    @Test
    public void findTeacherTest() {
        given(this.teachersRepository.find(any()))
                .willReturn(java.util.Optional.of(new Teacher(31L, "teacher", "teach")));
        Teacher teacher = usersService.findTeacher(31L);
        assert teacher.getId().equals(31L);
    }
}
