package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.grocerystore.services.UsersService;
import ru.itis.grocerystore.services.TechnologyStackService;

@Controller
public class StoreController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private TechnologyStackService technologyStackService;

    @GetMapping("/store")
    @PreAuthorize("hasRole('ADMIN') || hasRole('TEACHER') || hasRole('COMPANY')" )
    public String getStorePage(Model model) {
        model.addAttribute("students", usersService.getAll());
        model.addAttribute("techology_stack", technologyStackService.getAll());
        return "store";
    }
}
