package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.security.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/{id}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getProfilePage(@PathVariable("id") Long id) {
        Role role;
        ModelAndView modelAndView = new ModelAndView();
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if (userDetails.getUser().getId().equals(id)) {
            return new ModelAndView("redirect:/profile");
        }
        try {
            switch (profileService.getUserById(id, modelAndView)) {
                case ADMIN:
                    return new ModelAndView("redirect:/admin");
                case COMPANY:
                    modelAndView.setViewName("companyPage");
                case STUDENT:
                    modelAndView.setViewName("studentPage");
                case TEACHER:
                    modelAndView.setViewName("teacherPage");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        return modelAndView;
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getOwnProfilePage() {
        ModelAndView modelAndView = new ModelAndView();
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = userDetails.getUser();
        try {
            switch (profileService.getUserById(user.getId(), modelAndView)) {
                case ADMIN:
                    return new ModelAndView("redirect:/admin");
                case COMPANY:
                    modelAndView.setViewName("ownCompanyPage");
                case STUDENT:
                    modelAndView.setViewName("ownStudentPage");
                case TEACHER:
                    modelAndView.setViewName("ownTeacherPage");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role " + user.getRole());
        }
        return modelAndView;
    }
}
