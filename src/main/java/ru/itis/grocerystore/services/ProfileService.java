package ru.itis.grocerystore.services;

import org.springframework.ui.Model;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;

public interface ProfileService {
    Role getUserById(Long id, Model model);

    void setTeacherModel(User user, Model model);
    void setStudentModel(User user, Model model);
    void setCompanyModel(User user, Model model);
    void setAdminModel(User user, Model model);
}
