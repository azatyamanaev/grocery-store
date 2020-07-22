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
import ru.itis.grocerystore.models.Student;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.models.WorkExperience;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.StudentAttributesService;
import ru.itis.grocerystore.services.UsersService;

import java.util.Date;

@Controller
public class AddStudentAttributesController {

    @Autowired
    private StudentAttributesService service;

    @PostMapping("/addWorkExp")
    public String addWorkExp(WorkExpDto workExpDto, Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        //WorkExperience workExperience = WorkExperience.builder()
        //        .startDate(workExpDto.)
        //        .endDate(end)
        //        .organization(company)
        //        .position(position)
        //        .duties(duties)
        //        .student((Student) user)
        //        .build();
        //service.addWorkExp(workExperience);
        model.addAttribute("student", user);
        return "profile";
    }


}
