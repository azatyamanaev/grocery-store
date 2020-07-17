package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.repositories.CompaniesRepository;
import ru.itis.grocerystore.repositories.StudentsRepository;
import ru.itis.grocerystore.repositories.TeachersRepository;
import ru.itis.grocerystore.repositories.UsersRepository;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TeachersRepository teachersRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private CompaniesRepository companiesRepository;

    @Override
    public Role getUserById(Long id, Model model) {
        Optional<User> optionalUser = usersRepository.find(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            switch (user.getRole()) {
                case TEACHER:
                    setTeacherModel(user, model);
                    return Role.TEACHER;
                case STUDENT:
                    setStudentModel(user, model);
                    return Role.STUDENT;
                case COMPANY:
                    setCompanyModel(user, model);
                    return Role.COMPANY;
                case ADMIN:
                    setAdminModel(user, model);
                    return Role.ADMIN;
                default:
                    return null;
            }
        } else throw new IllegalArgumentException("User with ID: " + id + " not found");
    }

    @Override
    public void setTeacherModel(User user, Model model) {
        Optional<Teacher> teacherOptional = teachersRepository.find(user.getId());
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            model.addAttribute("teacher", teacher);
        } else throw new IllegalArgumentException("Teacher not found");
    }

    @Override
    public void setStudentModel(User user, Model model) {
        Optional<Student> studentOptional = studentsRepository.find(user.getId());
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            model.addAttribute("student", student);
        } else throw new IllegalArgumentException("Student not found");
    }

    @Override
    public void setCompanyModel(User user, Model model) {
        Optional<Company> companyOptional = companiesRepository.find(user.getId());
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            model.addAttribute("company", company);
        } else throw new IllegalArgumentException("Company not found");
    }

    @Override
    public void setAdminModel(User user, Model model) {
        // IDK WHAT TO DO
    }

}
