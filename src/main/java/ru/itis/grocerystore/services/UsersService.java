package ru.itis.grocerystore.services;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import ru.itis.grocerystore.models.*;

import java.util.List;

public interface UsersService {
    List<Student> getAllStudents();

    void updateStudent(Student student);

    void updateCompany(Company company);

    void updateTeacher(Teacher teacher);

    void deleteStudent(Long id);

    void deleteCompany(Long id);

    void deleteTeacher(Long id);

    void updateUser(User user);

    User findUser(Long id);

    Student findStudent(Long id);

    Teacher findTeacher(Long id);

    Company findCompany(Long id);

    void setEditContent(Model model, Long id);

    void changePassowrd(Authentication authentication, String password);

    User findUserByLogin(String login);
}
