package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.security.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.UsersService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private UsersService usersService;


    //TODO: сделать так, чтобы студент не мог смотреть страницу другого студента
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
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(id, modelAndView)) {
                case ADMIN:
                    return new ModelAndView("redirect:/admin");
                case COMPANY:
                    modelAndView.setViewName("companyProfile");
                case STUDENT:
                    modelAndView.setViewName("studentProfile");
                case TEACHER:
                    modelAndView.setViewName("teacherProfile");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        modelAndView.addObject("user", userDetails.getUser());
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteProfile(@PathVariable("id") Long id) {
        Role role;
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userDetails.getUser();
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (user.getRole()) {
                case TEACHER:
                    usersService.deleteTeacher(id);
                case STUDENT:
                    usersService.deleteStudent(id);
                case COMPANY:
                    usersService.deleteCompany(id);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        return "redirect:/";
    }
}
