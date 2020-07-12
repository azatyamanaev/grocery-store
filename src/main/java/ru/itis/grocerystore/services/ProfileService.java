package ru.itis.grocerystore.services;

import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;

public interface ProfileService {
    Role getUserById(Long id, ModelAndView modelAndView);

    void setTeacherModel(User user, ModelAndView modelAndView);
    void setStudentModel(User user, ModelAndView modelAndView);
    void setCompanyModel(User user, ModelAndView modelAndView);
    void setAdminModel(User user, ModelAndView modelAndView);
}
