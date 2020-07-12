package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.User;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Role getUserById(Long id, ModelAndView modelAndView) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            switch (user.getRole()) {
                case TEACHER:
                    setTeacherModel(user, modelAndView);
                    return Role.TEACHER;
                case STUDENT:
                    setStudentModel(user, modelAndView);
                    return Role.STUDENT;
                case COMPANY:
                    setCompanyModel(user, modelAndView);
                    return Role.COMPANY;
                case ADMIN:
                    setAdminModel(user, modelAndView);
                    return Role.ADMIN;
                default:
                    return null;
            }
        } else throw new IllegalArgumentException("User with ID: " + id + " not found");
    }

    @Override
    public Role getUser(User user, ModelAndView modelAndView) {
        return null;
    }

    @Override
    public void setTeacherModel(User user, ModelAndView modelAndView) {
//        EXAMPLE:
//        Teacher teacher = (Teacher) user;
//        modelAndView.addObject("teacher", teacher);
    }

    @Override
    public void setStudentModel(User user, ModelAndView modelAndView) {

    }

    @Override
    public void setCompanyModel(User user, ModelAndView modelAndView) {

    }

    @Override
    public void setAdminModel(User user, ModelAndView modelAndView) {

    }

}
