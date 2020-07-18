package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.grocerystore.repositories.TeachersRepository;

@Controller
public class AllTeachersController {

    @Autowired
    private TeachersRepository teachersRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        model.addAttribute("teachers", teachersRepository.findAll());
        return "allTeachers";
    }
}
