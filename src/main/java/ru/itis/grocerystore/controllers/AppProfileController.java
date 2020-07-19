package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.UsersService;


@Controller
public class AppProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private UsersService usersService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile/{id}")
    public String getProfilePage(@PathVariable("id") Long id, Model model) {
        Role role;
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        if (userDetails.getUser().getId().equals(id))
            return "redirect:/profile";
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(id, model)) {
                case ADMIN:
                    return "redirect:/admin";
                case COMPANY:
                    return "companyProfile";
                case STUDENT:
                    return "studentProfile";
                case TEACHER:
                    return "teacherProfile";
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        return "";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfile(Model model) {
        Role role;
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(userDetails.getUser().getId(), model)) {
                case ADMIN:
                    return "redirect:/admin";
                case COMPANY:
                    return "companyProfile";
                case STUDENT:
                    return "studentProfile";
                case TEACHER:
                    return "teacherProfile";
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + userDetails.getUser().getId());
        }
        return "";
    }
    @PostMapping("/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteProfile(@PathVariable("id") Long id) {
        Role role;
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (userDetails.getUser().getRole()) {
                case TEACHER:
                    usersService.deleteTeacher(id);
                    break;
                case STUDENT:
                    usersService.deleteStudent(id);
                    break;
                case COMPANY:
                    usersService.deleteCompany(id);
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        return "redirect:/";
    }
}
