package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.grocerystore.dto.WorkExpDto;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.StudentAttributesService;
import ru.itis.grocerystore.services.UsersService;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class ManageStudentAttributesController {

    @Autowired
    private StudentAttributesService service;
    @Autowired
    private ProfileService profileService;

    @PostMapping("/addWorkExp")
    public String addWorkExp(WorkExpDto workExpDto, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        WorkExperience workExperience = WorkExperience.builder()
                .startDate(workExpDto.getStart())
                .endDate(workExpDto.getEnd())
                .organization(workExpDto.getCompany())
                .position(workExpDto.getPosition())
                .duties(workExpDto.getDuties())
                .student((Student) user)
                .build();
        service.addWorkExp(workExperience);
        return "redirect:/profile";
    }

    @PostMapping("/addLanguage")
    public String addLanguage(String language, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        Language language1 = Language.builder()
                .language(language)
                .student((Student) user)
                .build();
        service.addLanguage(language1);
        return "redirect:/profile";
    }

    @PostMapping("/deleteLanguage")
    @ResponseBody
    public ResponseEntity<Object> deleteLanguage(@RequestParam("id") Long id) {
        service.deleteLanguage(id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/addAchievement")
    public String addAchievement(String achievement, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        Achievement achievement1 = Achievement.builder()
                .achievement(achievement)
                .student((Student) user)
                .build();
        service.addAchievement(achievement1);
        return "redirect:/profile";
    }

    @PostMapping("/deleteAchievement")
    @ResponseBody
    public ResponseEntity<Object> deleteAchievement(@RequestParam("id") Long id) {
        service.deleteAchievement(id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/addSkill")
    public String addSkill(String skill, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        Skill skill1 = Skill.builder()
                .skill(skill)
                .student((Student) user)
                .build();
        service.addSkill(skill1);
        return "redirect:/profile";
    }

    @PostMapping("/deleteSkill")
    @ResponseBody
    public ResponseEntity<Object> deleteSkill(@RequestParam("id") Long id) {
        service.deleteSkill(id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/deleteWorkExp")
    @ResponseBody
    public ResponseEntity<Object> deleteWorkExp(@RequestParam("id") Long id) {
        service.deleteWorkExp(id);
        return ResponseEntity.ok("success");
    }
}
