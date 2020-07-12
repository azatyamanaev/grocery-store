package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.grocerystore.dto.CompanyDto;
import ru.itis.grocerystore.services.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage() {
        return "adminPage";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin")
    public String createCompany(CompanyDto companyDto) {
        adminService.createCompany(companyDto);
        return "adminPage";
    }
}
