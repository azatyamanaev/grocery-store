package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.grocerystore.repositories.CompaniesRepository;

@Controller
public class AllCompaniesController {
    @Autowired
    private CompaniesRepository companiesRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/companies")
    public String getTeachers(Model model) {
        model.addAttribute("companies", companiesRepository.findAll());
        return "allCompanies";
    }
}
