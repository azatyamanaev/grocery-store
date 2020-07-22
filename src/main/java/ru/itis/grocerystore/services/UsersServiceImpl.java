package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.repositories.CompaniesRepository;
import ru.itis.grocerystore.repositories.StudentsRepository;
import ru.itis.grocerystore.repositories.TeachersRepository;
import ru.itis.grocerystore.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User findUser(Long id) {
        Optional<User> optionalUser = usersRepository.find(id);
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else throw new IllegalStateException("User is not present");
        return user;
    }

    @Override
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentsRepository.find(id);
        Student student;
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        } else throw new IllegalStateException("User is not present");
        return student;
    }

    @Override
    public Teacher findTeacher(Long id) {
        Optional<Teacher> optionalTeacher = teachersRepository.find(id);
        Teacher teacher;
        if (optionalTeacher.isPresent()) {
            teacher = optionalTeacher.get();
        } else throw new IllegalStateException("User is not present");
        return teacher;
    }

    @Override
    public Company findCompany(Long id) {
        Optional<Company> optionalCompany = companiesRepository.find(id);
        Company company;
        if (optionalCompany.isPresent()) {
            company = optionalCompany.get();
        } else throw new IllegalStateException("User is not present");
        return company;
    }

    @Override
    public void setEditContent(Model model, Long id) {
        User user = findUser(id);
        switch (user.getRole()) {
            case COMPANY:
                Company company = findCompany(id);
                model.addAttribute("user", company);
                break;
            case STUDENT:
                Student student = findStudent(id);
                model.addAttribute("user", student);
                break;
            case TEACHER:
                Teacher teacher = findTeacher(id);
                model.addAttribute("user", teacher);
                break;
            default:
                break;
        }
    }

    @Override
    public void changePassowrd(Authentication authentication, String password) {
        User user = (User) authentication.getPrincipal();
        user.setPassword(password);
        usersRepository.update(user);
    }
}
