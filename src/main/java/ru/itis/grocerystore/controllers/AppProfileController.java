package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.UsersService;


@Controller
public class AppProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private UsersService usersService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        Role role;
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("user", user);
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(user.getId(), model)) {
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
            throw new IllegalArgumentException("Unknown role for ID: " + user.getId());
        }
        return "";
    }

    @PostMapping("/delete")
    @PreAuthorize("isAuthenticated()")
    public String deleteProfile() {
        Role role;
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (user.getRole()) {
                case TEACHER:
                    usersService.deleteTeacher(user.getId());
                case STUDENT:
                    usersService.deleteStudent(user.getId());
                case COMPANY:
                    usersService.deleteCompany(user.getId());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + user.getId());
        }
        return "redirect:/";
    }
}
