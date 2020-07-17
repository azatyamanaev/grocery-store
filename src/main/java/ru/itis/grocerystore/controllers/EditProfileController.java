package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.UsersService;

@Controller
public class EditProfileController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ProfileService profileService;

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Long id, Model model) {
        Role role;
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("user", user);
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(id, model)) {
                case COMPANY:
                    return ("editCompanyProfile");
                case STUDENT:
                    return ("editStudentProfile");
                case TEACHER:
                    return ("editTeacherProfile");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        return "";
    }


    @GetMapping("/editStudent/{id}")
    public String getEditStudentProfilePage(@PathVariable("id") Long id, Model model) {
        usersService.setEditContent(model, id);
        return "editStudentProfile";
    }

    @PostMapping("/editStudent")
    public String editStudentProfile(@RequestBody Student student) {
        usersService.updateStudent(student);
        return "redirect:/profile";
    }

    @GetMapping("/editCompany/{id}")
    public String getEditCompanyProfilePage(@PathVariable("id") Long id, Model model) {
        usersService.setEditContent(model, id);
        return "editCompanyProfile";
    }

    @PostMapping("/editCompany")
    public String editCompanyProfile(@RequestBody Company company) {
        usersService.updateCompany(company);
        return "redirect:/profile";
    }

    @GetMapping("/editTeacher/{id}")
    public String getEditTeacherProfilePage(@PathVariable("id") Long id, Model model) {
        usersService.setEditContent(model, id);
        return "editTeacherProfile";
    }

    @PostMapping("/editTeacher")
    public String editTeacherProfile(@RequestBody Teacher teacher) {
        usersService.updateTeacher(teacher);
        return "redirect:/profile";
    }

    @PostMapping("/createNewPassword/{id}")
    public String changePassword(@PathVariable("id") Long id, @RequestParam String password) {
        Role role;
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        usersService.updateUser(user);
        return "redirect:/profile";
    }

    @GetMapping("/changePassword/{id}")
    public String changePassword(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "createNewPassword";
    }
}
