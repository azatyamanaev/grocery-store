package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.grocerystore.services.AuthService;

@RestController
public class LogoutController {

    @Autowired
    private AuthService authService;

    @GetMapping("/logout")
    @PreAuthorize("isAuthenticated()")

    public String logout(@RequestHeader("Authorization") String auth) {
        authService.logout(auth);
        return "/";
    }
}