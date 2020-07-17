package ru.itis.grocerystore.services;

import ru.itis.grocerystore.models.Company;
import ru.itis.grocerystore.models.Student;
import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.User;

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
}
