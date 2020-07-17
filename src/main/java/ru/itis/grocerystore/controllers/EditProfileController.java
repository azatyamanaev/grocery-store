package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.security.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.UsersService;

@Controller
public class EditProfileController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ProfileService profileService;

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Long id) {
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
                case COMPANY:
                    modelAndView.setViewName("editCompanyProfile.ftl");
                case STUDENT:
                    modelAndView.setViewName("editStudentProfile.ftl");
                case TEACHER:
                    modelAndView.setViewName("editTeacherProfile");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + id);
        }
        modelAndView.addObject("user", userDetails.getUser());
        return modelAndView;
    }

    @GetMapping("/editStudent")
    public String getEditStudentProfilePage() {
       return "editStudentProfile";
    }

    @PostMapping("/editStudent")
    public String editStudentProfile(@RequestBody Student student) {
        usersService.updateStudent(student);
        return "redirect:/profile";
    }

    @GetMapping("/editCompany")
    public String getEditCompanyProfilePage() {
        return "editCompanyProfile";
    }

    @PostMapping("/editCompany")
    public String editCompanyProfile(@RequestBody Company company) {
        usersService.updateCompany(company);
        return "redirect:/profile";
    }

    @GetMapping("/editTeacher")
    public String getEditTeacherProfilePage() {
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
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userDetails.getUser();
        usersService.updateUser(user);
       return "redirect:/profile";
    }

    @GetMapping("/changePassword/{id}")
    public String changePassword(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "createNewPassword";
    }
}
