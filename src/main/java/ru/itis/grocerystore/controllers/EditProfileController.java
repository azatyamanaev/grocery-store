package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.UsersService;

@Controller
@PreAuthorize("isAuthenticated()")
public class EditProfileController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ProfileService profileService;

    @GetMapping("/edit")
    public String getEditPage(Model model) {
        Role role;
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userDetails.getUser();
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(user.getId(), model)) {
                case COMPANY:
                    model.addAttribute("user", usersService.findCompany(user.getId()));
                    return ("editCompanyProfile");
                case STUDENT:
                    model.addAttribute("user", usersService.findStudent(user.getId()));
                    return ("editStudentProfile");
                case TEACHER:
                    model.addAttribute("user", usersService.findTeacher(user.getId()));
                    return ("editTeacherProfile");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + user.getId());
        }
        return "";
    }

    @PostMapping("/editStudent")
    public String editStudentProfile(@RequestBody Student student) {
        usersService.updateStudent(student);
        return "redirect:/profile";
    }

    @PostMapping("/editCompany")
    public String editCompanyProfile(@RequestBody Company company) {
        usersService.updateCompany(company);
        return "redirect:/profile";
    }


    @GetMapping("/editTeacher")
    public String getEditTeacherPage(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "editTeacherProfile";
    }
    @PostMapping("/editTeacher")
    public String editTeacherProfile(@RequestParam String name, @RequestParam String lastName, @RequestParam String patronymic,
                                     @RequestParam String about, @RequestParam String position) {
        usersService.updateTeacher(Teacher.builder()
        .name(name)
        .lastName(lastName)
        .patronymic(patronymic)
        .about(about)
        .position(position)
        .build());
        return "redirect:/profile";
    }

    @PostMapping("/createNewPassword")
    public String changePassword(@RequestParam String password, Authentication authentication) {
        usersService.changePassowrd(authentication, password);
        return "redirect:/profile";
    }

    @GetMapping("/createNewPassword")
    public String changePassword() {
        return "createNewPassword";
    }
}
