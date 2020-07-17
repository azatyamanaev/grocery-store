package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.services.ProfileService;

@Controller("myProfileController")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    //TODO: сделать так, чтобы студент не мог смотреть страницу другого студента
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile/{id}")
    public String getProfilePage(@PathVariable("id") Long id, Model model) {
        Role role;
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    model.addAttribute("user", user);
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(id, model)) {
                case ADMIN:
                    return ("redirect:/admin");
                case COMPANY:
                    return ("companyProfile");
                case STUDENT:
                    return ("studentProfile");
                case TEACHER:
                    return ("teacherProfile");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        return "";
    }
}
