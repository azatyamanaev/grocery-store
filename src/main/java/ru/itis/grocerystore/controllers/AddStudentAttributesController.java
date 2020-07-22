package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public ResponseEntity<Object> addWorkExp(@RequestBody WorkExperience workExperience, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        workExperience.setStudent((Student) user);
        service.addWorkExp(workExperience);
        return ResponseEntity.ok("You have successfully added new work experience");
    }
}
