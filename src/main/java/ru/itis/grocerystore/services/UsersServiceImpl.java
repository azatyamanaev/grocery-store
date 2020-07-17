package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.Company;
import ru.itis.grocerystore.models.Student;
import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.CompaniesRepository;
import ru.itis.grocerystore.repositories.StudentsRepository;
import ru.itis.grocerystore.repositories.TeachersRepository;
import ru.itis.grocerystore.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private CompaniesRepository companiesRepository;
    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public void updateStudent(Student student) {
        studentsRepository.update(student);
    }

    @Override
    public void updateCompany(Company company) {
        companiesRepository.update(company);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teachersRepository.update(teacher);
    }

    @Override
    public void deleteStudent(Long id) {
        studentsRepository.delete(id);
    }

    @Override
    public void deleteCompany(Long id) {
        companiesRepository.delete(id);
    }

    @Override
    public void deleteTeacher(Long id) {
        teachersRepository.delete(id);
    }

    @Override
    public void updateUser(User user) {
        usersRepository.update(user);
    }
}
